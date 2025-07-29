package com.algar.query_dlr_api.model;

import java.util.Date;

public record DlrResponseDTO(String id,
                             String sourceAddr,
                             String destinationAddr,
                             Date submissionDate,
                             Date finalDate) {
}
