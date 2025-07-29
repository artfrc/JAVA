package com.algar.query_dlr_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SHORT_MESSAGE", schema = "URANOADM")
public class Dlr {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "RESPONSE_ID")
    private String responseId;

    @Column(name = "SERVICE_TYPE")
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Column(name = "SOURCE_ADDR")
    private String sourceAddr;

    @Column(name = "DESTINATION_ADDR")
    private String destinationAddr;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "REQUIRE_DLR")
    private String requireDlr;

    @Column(name = "SUBMISSION_DATE")
    private Date submissionDate;

    @Column(name = "SCHEDULE_DATE")
    private Date scheduleDate;

    @Column(name = "FINAL_DATE")
    private Date finalDate;

    @Column(name = "DELIVERY_STATUS")
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Column(name = "DELIVERY_ERROR_CODE")
    private Integer deliveryErrorCode;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "DELIVERY_COUNT")
    private Integer deliveryCount;

    @Column(name = "SUBMIT_MULTI_ID")
    private Integer submitMultiId;

    @Column(name = "MESSAGE_PARTS")
    private Integer messageParts;

    @Column(name = "PART_NUMBER")
    private Integer partNumber;

    @Column(name = "LAST_ERROR")
    private String lastError;

    @Column(name = "ORIGIN_CLIENT")
    private String originClient;

    @Column(name = "DESTINATION_CLIENT")
    private String destinationClient;

    @Column(name = "WORKER")
    private String worker;

    @Column(name = "WORKER_LOCK_TIME")
    private Date workerLockTime;

    @Column(name = "DLR_SEQUENCE_ID")
    private String dlrSequenceId;

    @Column(name = "NOTIFY_DLR")
    private String notifyDlr;

    @Column(name = "RECEIVER")
    private String receiver;

    @Column(name = "DLR_STATUS")
    private String dlrStatus;

    @Column(name = "DESTINATION_CLIENT_TYPE")
    private String destinationClientType;
}
