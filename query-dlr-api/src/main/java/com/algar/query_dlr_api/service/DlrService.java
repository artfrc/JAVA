package com.algar.query_dlr_api.service;

import com.algar.query_dlr_api.model.Dlr;
import com.algar.query_dlr_api.model.DlrResponseDTO;
import com.algar.query_dlr_api.model.ServiceType;
import com.algar.query_dlr_api.repository.DlrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

@Service
public class DlrService {

    @Autowired
    private DlrRepository dlrRepository;

    @Autowired
    private DateService dateService;

    public ResponseEntity<List<DlrResponseDTO>> getDlrs(
            String sourceAddr,
            String destinationAddr,
            Date submissionDate,
            Date endDate,
            Pageable pageable) {

        Specification<Dlr> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            dateService.validateDates(submissionDate, endDate);

            predicates.add(cb.equal(root.get("serviceType"), ServiceType.DLR));


            if(sourceAddr != null) {
                predicates.add(cb.equal(root.get("sourceAddr"), sourceAddr));
            }

            if(destinationAddr != null) {
                predicates.add(cb.equal(root.get("destinationAddr"), destinationAddr));
            }

            if(submissionDate != null && endDate != null) {
                predicates.add(cb.between(root.get("submissionDate"), submissionDate, endDate));
            } else if(submissionDate != null) {
                predicates.add(cb.between(root.get("submissionDate"), submissionDate, new Date()));
            } else if(endDate != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("submissionDate"), endDate));
            }

            return predicates.isEmpty() ? cb.conjunction() : cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<Dlr> page = dlrRepository.findAll(spec, pageable);
        List<Dlr> dlrs = page.getContent();

        return ResponseEntity.ok(convertDlrToDlrResponseDTO(dlrs));
    }

    private List<DlrResponseDTO> convertDlrToDlrResponseDTO(List<Dlr> dlrs) {
        List<DlrResponseDTO> response = new ArrayList<>();

        for(Dlr dlr : dlrs) {
            DlrResponseDTO dto = new DlrResponseDTO(
                    dlr.getId(),
                    dlr.getSourceAddr(),
                    dlr.getDestinationAddr(),
                    dlr.getSubmissionDate(),
                    dlr.getFinalDate()
            );
            response.add(dto);
        }

            return response;
    }

}
