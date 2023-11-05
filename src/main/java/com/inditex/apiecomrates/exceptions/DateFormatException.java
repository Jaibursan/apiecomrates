package com.inditex.apiecomrates.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DateFormatException extends RuntimeException {
    
    public DateFormatException(String message) {
        super(message);
    }
    
}
