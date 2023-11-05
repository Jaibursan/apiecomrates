package com.inditex.apiecomrates.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.apiecomrates.api.service.BrandsService;
import com.inditex.apiecomrates.domain.model.Brand;

/**
 * BrandsController
 * This class is the controller used to process REST requests related to brands
 */
@RestController 
public class BrandsController {
    
    @Autowired
    private BrandsService brandsService;
    
    /**
     * getBrands
     * This method is used to get all brands
     * @return List of brands
     */
    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public List<Brand> getBrands() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("[BrandsController] Recibida nueva petición GET /brands");
        List<Brand> response = brandsService.getBrands();
        System.out.println("-----------------------------------------------------------------------");
        return response;
    }

    /**
     * getBrandsBrandId
     * This method is used to get the brand detail, searching by id
     * @param brandId
     * @return Brand detail
     */
    @RequestMapping(value = "/brands/{brandId}", method = RequestMethod.GET)
    public Brand getBrandsBrandId(
        @PathVariable(name = "brandId") String brandId
    ) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("[BrandsController] Recibida nueva petición GET /brands/" + brandId);
        Brand response = brandsService.getBrandsBrandId(brandId);
        System.out.println("-----------------------------------------------------------------------");
        return response;
    }

}


