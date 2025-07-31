package com.algar.query_dlr_api.service;

import com.algar.query_dlr_api.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DateService {

    public void validateDates(Date submissionDate, Date endDate) {
        Date currentDate = new Date();

        if (submissionDate != null && submissionDate.after(currentDate)) {
            throw new BadRequestException("Submission date cannot be in the future.");
        }

        if (endDate != null && endDate.after(currentDate)) {
            throw new BadRequestException("End date cannot be in the future.");
        }

        if (submissionDate != null && endDate != null && submissionDate.after(endDate)) {
            throw new BadRequestException("Submission date must be before end date.");
        }
    }
}
