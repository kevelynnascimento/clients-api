package com.dev.clients.infra.exceptions.handlers;

import com.dev.clients.infra.exceptions.responses.HttpErrorResponse;
import com.dev.clients.infra.exceptions.types.HttpBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpExceptionHandler {
    @ExceptionHandler(HttpBadRequestException.class)
    public ResponseEntity<HttpErrorResponse> handleBadRequestException(HttpBadRequestException ex) {
        var errorResponse = new HttpErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpErrorResponse> handleGenericException(Exception ex) {
        var errorResponse = new HttpErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Unexpected error! Try again later.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}