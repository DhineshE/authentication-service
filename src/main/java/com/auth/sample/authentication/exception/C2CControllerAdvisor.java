package com.auth.sample.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class C2CControllerAdvisor {

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ExceptionHandler(UserApplicationException.class)
    public ResponseEntity<Object> handleValidationException(
                    UserApplicationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}