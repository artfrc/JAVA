package com.algar.query_dlr_api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class RestErrorMessage {

    private int status;
    private  String message;

    @Override
    public String toString() {
        return "RestErrorMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
