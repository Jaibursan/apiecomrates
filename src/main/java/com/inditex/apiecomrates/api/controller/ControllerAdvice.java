package com.inditex.apiecomrates.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inditex.apiecomrates.exceptions.DateFormatException;
import com.inditex.apiecomrates.exceptions.NoSuchElementFoundException;

/**
 * ControllerAdvice
 * This class is used to handle exceptions in the controllers
 */
@RestControllerAdvice
public class ControllerAdvice {
    
    /**
     * ExceptionHandler
     * This method is used to handle exceptions returning an HTTP 500
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException (Exception exception) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(exception.getMessage());
    }

    /**
     * handleNoSuchElementFoundException
     * This method is used to handle NoSuchElementFoundException returning an HTTP 404
     * @param exception
     * @return ResponseEntity
     */
    @ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(NoSuchElementFoundException exception) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.getMessage());
    }

    /**
     * handleDateFormatException
     * This method is used to handle DateFormatException returning an HTTP 400
     * @param exception
     * @return ResponseEntity
     */
    @ExceptionHandler(DateFormatException.class)
    public ResponseEntity<String> handleDateFormatException(DateFormatException exception) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(exception.getMessage());
    }
    
}
