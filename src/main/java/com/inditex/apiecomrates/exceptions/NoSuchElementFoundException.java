package com.inditex.apiecomrates.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException extends RuntimeException {
    
    public NoSuchElementFoundException(String message) {
        super(message);
    }
    
}
