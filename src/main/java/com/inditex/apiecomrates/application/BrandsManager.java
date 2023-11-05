package com.inditex.apiecomrates.application;

import java.util.List;

import com.inditex.apiecomrates.domain.model.Brand;

/**
 * BrandsManager
 * This interface contains the declaration of methods that execute the business logic related to brands
 */
public interface BrandsManager {
    
    List<Brand> execute();
    
    Brand execute(String brandId);
    
}
