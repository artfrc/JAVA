package com.training.demo.exception;

public class RestErrorMessage {

    private int status;
    private  String message;

    public RestErrorMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RestErrorMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
