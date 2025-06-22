package com.aprimorapring.aprimora.controller.exceptions;

import com.aprimorapring.aprimora.services.exceptions.DatabaseException;
import com.aprimorapring.aprimora.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler extends RuntimeException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        return getStandardErrorResponseEntity(e, request, "Resource not found for ", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dataBase(DatabaseException e, HttpServletRequest request) {
        return getStandardErrorResponseEntity(e, request, "Database error", HttpStatus.BAD_REQUEST);
    }

    private static ResponseEntity<StandardError> getStandardErrorResponseEntity(Exception e, HttpServletRequest request,
                                                                                String erro, HttpStatus status) {
        StandardError err = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
