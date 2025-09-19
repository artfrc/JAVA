package com.algar.query_dlr_api.controller;

import com.algar.query_dlr_api.model.Dlr;
import com.algar.query_dlr_api.model.DlrResponseDTO;

import com.algar.query_dlr_api.service.DlrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dlr")
public class DlrController {

    @Autowired
    private DlrService dlrService;

    @GetMapping
    public ResponseEntity<List<DlrResponseDTO>> getDlrs(
    @RequestParam(required = false) String sourceAddr,
    @RequestParam(required = false) String destinationAddr,
    @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date submissionDate,
    @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate,
    Pageable pageable) {
return dlrService.getDlrs(sourceAddr, destinationAddr,submissionDate, endDate, pageable);
    }

}
