package com.mikaelparsekyan.eventservice.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.mikaelparsekyan.common.util.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EventControllerAdvice {

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException exception) {
        return new ResponseEntity<>(ResponseObject.build(exception.getOriginalMessage()), HttpStatus.BAD_REQUEST);
    }
}
