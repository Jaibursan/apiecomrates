package com.inditex.apiecomrates.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.apiecomrates.api.service.BrandsService;
import com.inditex.apiecomrates.domain.model.Brand;

@RestController 
public class BrandsController {
    
    @Autowired
    private BrandsService brandsService;

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public List<Brand> getBrands(
        @RequestParam(name = "productId", required = false) String productId,
        @RequestParam(name = "brandList", required = false) String brandList,
        @RequestParam(name = "startDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startDate,
        @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endDate
    ) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("[BrandsController] Recibida nueva petición GET /brands");
        List<Brand> response = brandsService.getBrands();
        System.out.println("-----------------------------------------------------------------------");
        return response;
    }

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


