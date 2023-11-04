package com.inditex.apiecomrates.application;

import java.util.List;

import com.inditex.apiecomrates.domain.model.Brand;

public interface BrandsManager {
    
    List<Brand> execute();
    
    Brand execute(String brandId);
    
}
