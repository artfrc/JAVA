package com.art.email_service.application;

import com.art.email_service.adapters.EmailSenderGateway;
import com.art.email_service.core.EmailSenderUserCase;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailSenderService implements EmailSenderUserCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailGateway){
        this.emailSenderGateway = emailGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
