package com.ericsson.homework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<String> handleCustomExceptions(BaseException e) {
        switch (e.getType()) {
            case NOT_FOUND:
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            default:
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}