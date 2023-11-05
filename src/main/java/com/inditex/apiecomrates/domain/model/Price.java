package com.inditex.apiecomrates.domain.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Price
 * DTO for price
 */
@Data
@AllArgsConstructor
public class Price {
    
    private String productId;

	private String brandId;

    private String priceList;

    private Date startDate;

    private Date endDte;

    private Money price;

}
