package com.algar.query_dlr_api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<RestErrorMessage> BadRequestHandler(Exception ex, WebRequest req){
        RestErrorMessage httpError = new RestErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage());
        return new ResponseEntity<>(httpError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<RestErrorMessage> handlerException(Exception ex, WebRequest req){
        RestErrorMessage httpError = new RestErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "System error, please contact the administrator.");
        return new ResponseEntity<>(httpError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}