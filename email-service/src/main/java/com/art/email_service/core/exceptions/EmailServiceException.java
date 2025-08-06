package com.art.email_service.core.exceptions;

import com.art.email_service.application.EmailSenderService;

public class EmailServiceException extends RuntimeException{

    public EmailServiceException(String message) {
        super(message);
    }

    public EmailServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
