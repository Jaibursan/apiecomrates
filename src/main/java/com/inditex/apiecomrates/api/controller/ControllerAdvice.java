package com.inditex.apiecomrates.api.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ControllerAdvice
 * This class is used to handle exceptions in the controllers
 */
@RestControllerAdvice
public class ControllerAdvice {
    
    /**
     * ExceptionHandler
     * This method is used to handle exceptions
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler (Exception e) {
        return "ERROR: " + e;
    }
}
