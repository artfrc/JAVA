package com.algar.query_dlr_api.service;

import com.algar.query_dlr_api.exception.BadRequestException;
import com.algar.query_dlr_api.model.DeliveryStatus;
import com.algar.query_dlr_api.model.Dlr;
import com.algar.query_dlr_api.model.DlrResponseDTO;
import com.algar.query_dlr_api.model.ServiceType;
import com.algar.query_dlr_api.repository.DlrRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DlrServiceTest {

    private Dlr dlr;
    private DlrResponseDTO dlrResponseDTO;
    private Pageable pageable;

    @Mock
    private DlrRepository dlrRepository;

    private  DateService dateService;

    @InjectMocks
    private DlrService dlrService;

    @BeforeEach
    void setUp() {
        pageable = PageRequest.of(0, 5);
        dateService = new DateService();

        dlr = createDlr("1", "10", "12345", "0987654321");
        dlrResponseDTO = new DlrResponseDTO(
                dlr.getId(),
                dlr.getSourceAddr(),
                dlr.getDestinationAddr(),
                dlr.getSubmissionDate(),
                dlr.getFinalDate()
        );
    }

    @Test
    void shouldReturnEmptyList_WhenSourceAddrDoesNotMatchAnyRecord() {

        String SourceAddr = "123456";
        List<Dlr> dlrList = Collections.EMPTY_LIST;
        Page<Dlr> dlrPage = new PageImpl<>(dlrList, pageable, dlrList.size());

        when(dlrRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(dlrPage);

        ResponseEntity<List<DlrResponseDTO>> response = dlrService.getDlrs(SourceAddr, null, null, null, pageable);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(0, response.getBody().size());

        verify(dlrRepository, times(1)).findAll(any(Specification.class), eq(pageable));
    }

    @Test
    void shouldReturnAllDlrs_WhenNoFiltersProvided() {

        List<Dlr> dlrList = Collections.singletonList(dlr);
        Page<Dlr> dlrPage = new PageImpl<>(dlrList, pageable, dlrList.size());

        when(dlrRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(dlrPage);

        ResponseEntity<List<DlrResponseDTO>> response = dlrService.getDlrs(null, null, null, null, pageable);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        assertEquals(dlrResponseDTO, response.getBody().get(0));

        verify(dlrRepository, times(1)).findAll(any(Specification.class), eq(pageable));
    }

    @Test
    void shouldReturnDlrsFilteredBySourceAddr_WhenOnlySourceAddrIsProvided() {

        String sourceAddr = "12345";
        List<Dlr> dlrList = Collections.singletonList(dlr);
        Page<Dlr> dlrPage = new PageImpl<>(dlrList, pageable, dlrList.size());

        when(dlrRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(dlrPage);

        ResponseEntity<List<DlrResponseDTO>> response = dlrService.getDlrs(sourceAddr, null, null, null, pageable);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        assertEquals(dlrResponseDTO, response.getBody().get(0));

        verify(dlrRepository, times(1)).findAll(any(Specification.class), eq(pageable));
    }

    @Test
    void shouldReturnDlrsFilteredByDestinationAddr_WhenOnlyDestinationAddrIsProvided() {

        String DestinationAddr = "0987654321";
        List<Dlr> dlrList = Collections.singletonList(dlr);
        Page<Dlr> dlrPage = new PageImpl<>(dlrList, pageable, dlrList.size());

        when(dlrRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(dlrPage);

        ResponseEntity<List<DlrResponseDTO>> response = dlrService.getDlrs(null, DestinationAddr, null, null, pageable);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        assertEquals(dlrResponseDTO, response.getBody().get(0));

        verify(dlrRepository, times(1)).findAll(any(Specification.class), eq(pageable));
    }

    @Test
    void shouldReturnDlrsFilteredBySubmissionAndEndDate_WhenBothAreProvided() {

        Date submissionDate = new Date();
        Date endDate = new Date();
        List<Dlr> dlrList = Collections.singletonList(dlr);
        Page<Dlr> dlrPage = new PageImpl<>(dlrList, pageable, dlrList.size());

        when(dlrRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(dlrPage);

        ResponseEntity<List<DlrResponseDTO>> response = dlrService.getDlrs(null, null, submissionDate, endDate, pageable);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        assertEquals(dlrResponseDTO, response.getBody().get(0));
        assertDoesNotThrow(() -> {
            dateService.validateDates(submissionDate, endDate);
        });

        verify(dlrRepository, times(1)).findAll(any(Specification.class), eq(pageable));
    }

    @Test
    void shouldReturnDlrsFilteredBySubmissionDate_WhenOnlySubmissionDateIsProvided() {

        Date submissionDate = new Date();
        List<Dlr> dlrList = Collections.singletonList(dlr);
        Page<Dlr> dlrPage = new PageImpl<>(dlrList, pageable, dlrList.size());

        when(dlrRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(dlrPage);

        ResponseEntity<List<DlrResponseDTO>> response = dlrService.getDlrs(null, null, submissionDate, null, pageable);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        assertDoesNotThrow(() -> {
            dateService.validateDates(submissionDate, null);
        });

        verify(dlrRepository, times(1)).findAll(any(Specification.class), eq(pageable));

    }

    @Test
    void shouldReturnDlrsFilteredByEndDate_WhenOnlyEndDateIsProvided() {

        Date endDate = new Date();
        List<Dlr> dlrList = Collections.singletonList(dlr);
        Page<Dlr> dlrPage = new PageImpl<>(dlrList, pageable, dlrList.size());

        when(dlrRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(dlrPage);

        ResponseEntity<List<DlrResponseDTO>> response = dlrService.getDlrs(null, null, endDate, null, pageable);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        assertDoesNotThrow(() -> {
            dateService.validateDates(endDate, null);
        });

        verify(dlrRepository, times(1)).findAll(any(Specification.class), eq(pageable));

    }

    @Test
    void shouldReturnDlrsFilteredBySourceAndDestinationAddr_WhenBothAreProvided() {

        String SourceAddr = "12345";
        String DestinationAddr = "0987654321";
        List<Dlr> dlrList = Collections.singletonList(dlr);
        Page<Dlr> dlrPage = new PageImpl<>(dlrList, pageable, dlrList.size());

        when(dlrRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(dlrPage);

        ResponseEntity<List<DlrResponseDTO>> response = dlrService.getDlrs(SourceAddr, DestinationAddr, null, null, pageable);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        assertEquals(dlrResponseDTO, response.getBody().get(0));

        verify(dlrRepository, times(1)).findAll(any(Specification.class), eq(pageable));
    }

    @Test
        void shouldReturnDlrsFilteredByAllFilters() {

        String SourceAddr = "12345";
        String DestinationAddr = "0987654321";
        Date submissionDate = new Date();
        Date endDate = new Date();
        List<Dlr> dlrList = Collections.singletonList(dlr);
        Page<Dlr> dlrPage = new PageImpl<>(dlrList, pageable, dlrList.size());

        when(dlrRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(dlrPage);

        ResponseEntity<List<DlrResponseDTO>> response = dlrService.getDlrs(SourceAddr, DestinationAddr, submissionDate, endDate, pageable);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        assertEquals(dlrResponseDTO, response.getBody().get(0));

        verify(dlrRepository, times(1)).findAll(any(Specification.class), eq(pageable));
        assertDoesNotThrow(() -> {
            dateService.validateDates(submissionDate, endDate);
        });
    }

    @Test
    void shouldReturnThrowBadRequestExceptionBecauseOfFutureDate() {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.YEAR,1);
        Date submissionDate = day.getTime();
        assertThrows(BadRequestException.class, () -> {
            dateService.validateDates(submissionDate, null);
        });

        verify(dlrRepository, times(0)).findAll(any(Specification.class), eq(pageable));
    }


    private Dlr createDlr(
            String id,
            String responseId,
            String sourceAddr,
            String destinationAddr) {

        Dlr dlr = new Dlr();

        dlr.setId(id);
        dlr.setResponseId(responseId);
        dlr.setServiceType(ServiceType.DLR);
        dlr.setSourceAddr(sourceAddr);
        dlr.setDestinationAddr(destinationAddr);
        dlr.setPriority(1);
        dlr.setRequireDlr("Y");
        dlr.setSubmissionDate(new Date());
        dlr.setScheduleDate(new Date());
        dlr.setFinalDate(new Date());
        dlr.setDeliveryStatus(DeliveryStatus.SCHEDULED);
        dlr.setDeliveryErrorCode(0);
        dlr.setText("Sample message text");
        dlr.setDeliveryCount(0);
        dlr.setSubmitMultiId(1);
        dlr.setMessageParts(1);
        dlr.setPartNumber(1);
        dlr.setLastError(null);
        dlr.setOriginClient("ClientA");
        dlr.setDestinationClient("ClientB");
        dlr.setWorker("Worker1");
        dlr.setWorkerLockTime(null);
        dlr.setDlrSequenceId("DLR-" + System.currentTimeMillis());
        dlr.setNotifyDlr("N");
        dlr.setReceiver("Receiver1");
        dlr.setDlrStatus("OK");
        dlr.setDestinationClientType("TYPE_A");

        return dlr;
    }
}