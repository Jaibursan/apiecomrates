package com.inditex.apiecomrates.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Money {
    
    private final BigDecimal amount;

	private final String currency;

}
