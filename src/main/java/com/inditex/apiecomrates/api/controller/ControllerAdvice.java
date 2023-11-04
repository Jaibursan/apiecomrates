package com.inditex.apiecomrates.api.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    
    @ExceptionHandler(Exception.class)
    public String exceptionHandler (Exception e) {
        return "ERROR: " + e;
    }
}
