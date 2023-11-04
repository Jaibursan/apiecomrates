package com.inditex.apiecomrates.domain.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Price {
    
    private final String productId;

	private final String brandId;

    private final String priceList;

    private final Date startDate;

    private final Date endDte;

    private final Money price;

}
