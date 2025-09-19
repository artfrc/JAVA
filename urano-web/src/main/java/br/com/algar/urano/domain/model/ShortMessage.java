package br.com.algar.urano.domain.model;

import br.com.algar.urano.domain.enums.DeliveryStatus;
import br.com.algar.urano.domain.enums.ServiceType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SHORT_MESSAGE", schema = "URANOADM")
public class ShortMessage {

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

    @Column(name = "RELATIONAL_ID")
    private String relationalId;

    public ShortMessage() {
    }

    public ShortMessage(String id, String responseId, ServiceType serviceType, String sourceAddr, String destinationAddr, Integer priority, String requireDlr, Date submissionDate, Date scheduleDate, Date finalDate, DeliveryStatus deliveryStatus, Integer deliveryErrorCode, String text, Integer deliveryCount, Integer submitMultiId, Integer messageParts, Integer partNumber, String lastError, String originClient, String destinationClient, String worker, Date workerLockTime, String dlrSequenceId, String notifyDlr, String receiver, String relationalId) {
        this.id = id;
        this.responseId = responseId;
        this.serviceType = serviceType;
        this.sourceAddr = sourceAddr;
        this.destinationAddr = destinationAddr;
        this.priority = priority;
        this.requireDlr = requireDlr;
        this.submissionDate = submissionDate;
        this.scheduleDate = scheduleDate;
        this.finalDate = finalDate;
        this.deliveryStatus = deliveryStatus;
        this.deliveryErrorCode = deliveryErrorCode;
        this.text = text;
        this.deliveryCount = deliveryCount;
        this.submitMultiId = submitMultiId;
        this.messageParts = messageParts;
        this.partNumber = partNumber;
        this.lastError = lastError;
        this.originClient = originClient;
        this.destinationClient = destinationClient;
        this.worker = worker;
        this.workerLockTime = workerLockTime;
        this.dlrSequenceId = dlrSequenceId;
        this.notifyDlr = notifyDlr;
        this.receiver = receiver;
        this.relationalId = relationalId;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getSourceAddr() {
        return sourceAddr;
    }

    public void setSourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;
    }

    public String getDestinationAddr() {
        return destinationAddr;
    }

    public void setDestinationAddr(String destinationAddr) {
        this.destinationAddr = destinationAddr;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getRequireDlr() {
        return requireDlr;
    }

    public void setRequireDlr(String requireDlr) {
        this.requireDlr = requireDlr;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getDeliveryErrorCode() {
        return deliveryErrorCode;
    }

    public void setDeliveryErrorCode(Integer deliveryErrorCode) {
        this.deliveryErrorCode = deliveryErrorCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getDeliveryCount() {
        return deliveryCount;
    }

    public void setDeliveryCount(Integer deliveryCount) {
        this.deliveryCount = deliveryCount;
    }

    public Integer getSubmitMultiId() {
        return submitMultiId;
    }

    public void setSubmitMultiId(Integer submitMultiId) {
        this.submitMultiId = submitMultiId;
    }

    public Integer getMessageParts() {
        return messageParts;
    }

    public void setMessageParts(Integer messageParts) {
        this.messageParts = messageParts;
    }

    public Integer getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(Integer partNumber) {
        this.partNumber = partNumber;
    }

    public String getLastError() {
        return lastError;
    }

    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public String getOriginClient() {
        return originClient;
    }

    public void setOriginClient(String originClient) {
        this.originClient = originClient;
    }

    public String getDestinationClient() {
        return destinationClient;
    }

    public void setDestinationClient(String destinationClient) {
        this.destinationClient = destinationClient;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public Date getWorkerLockTime() {
        return workerLockTime;
    }

    public void setWorkerLockTime(Date workerLockTime) {
        this.workerLockTime = workerLockTime;
    }

    public String getDlrSequenceId() {
        return dlrSequenceId;
    }

    public void setDlrSequenceId(String dlrSequenceId) {
        this.dlrSequenceId = dlrSequenceId;
    }

    public String getNotifyDlr() {
        return notifyDlr;
    }

    public void setNotifyDlr(String notifyDlr) {
        this.notifyDlr = notifyDlr;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRelationalId() {
        return relationalId;
    }

    public void setRelationalId(String relationalId) {
        this.relationalId = relationalId;
    }

}
