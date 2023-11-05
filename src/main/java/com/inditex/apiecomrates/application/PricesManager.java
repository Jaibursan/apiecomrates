package com.inditex.apiecomrates.application;

import java.util.Date;
import java.util.List;

import com.inditex.apiecomrates.domain.model.Price;

/**
 * PricesManager
 * This interface contains the declaration of methods that execute the business logic related to prices
 */
public interface PricesManager {
    
    List<Price> execute();

    Price execute(String brandtId, String productId, Date date);

}
