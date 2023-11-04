package com.inditex.apiecomrates.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Money {
    
    private BigDecimal amount;

	private String currency;

}
