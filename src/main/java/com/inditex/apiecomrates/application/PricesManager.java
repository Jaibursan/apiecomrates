package com.inditex.apiecomrates.application;

import java.util.Date;
import java.util.List;

import com.inditex.apiecomrates.domain.model.Price;

public interface PricesManager {
    List<Price> execute(String productId, String priceList, Date startDate, Date endDate);

}
