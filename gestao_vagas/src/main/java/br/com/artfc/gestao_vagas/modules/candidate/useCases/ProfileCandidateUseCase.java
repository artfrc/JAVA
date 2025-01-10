package br.com.artfc.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.artfc.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.artfc.gestao_vagas.modules.candidate.dto.ProfileCandidateDTO;

@Service
public class ProfileCandidateUseCase {
   

      @Autowired
      private CandidateRepository candidateRepository;

      public ProfileCandidateDTO execute(UUID IdCandidate) {
         var candidate = this.candidateRepository.findById(IdCandidate)
         .orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
         });

         var candidateDTO = new ProfileCandidateDTO(
            candidate.getDescription(),
            candidate.getUsername(),
            candidate.getEmail(),
            candidate.getId(),
            candidate.getName());
            
            return candidateDTO;
      }


}
