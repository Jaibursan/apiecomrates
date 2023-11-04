package com.inditex.apiecomrates.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.apiecomrates.application.BrandsManager;
import com.inditex.apiecomrates.domain.model.Brand;

@Service
public class BrandsService {
    
    @Autowired
    private BrandsManager brandsManager;
    
    public List<Brand> getBrands() {
        System.out.println("[BrandsService][getBrands] INICIO");
        List<Brand> response = brandsManager.execute();
        System.out.println("[BrandsService][getBrands] Se han encontrado " + (response != null ? response.size() : 0) + " resultados");
        System.out.println("[BrandsService][getBrands] FIN");
        return response; 
    }

    public Brand getBrandsBrandId(String brandId) {
        System.out.println("[BrandsService][getBrandsBrandId] INICIO");
        System.out.println("[BrandsService][getBrandsBrandId] Id: " + brandId);
        Brand response = brandsManager.execute(brandId);
        System.out.println("[BrandsService][getBrandsBrandId] FIN");
        return response; 
    }
}
