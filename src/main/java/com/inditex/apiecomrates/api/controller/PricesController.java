package com.inditex.apiecomrates.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.apiecomrates.api.service.PricesService;
import com.inditex.apiecomrates.domain.model.Price;

@RestController 
public class PricesController {
    
    @Autowired
    private PricesService pricesService;

    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public List<Price> getPrices(
        @RequestParam(name = "productId", required = false) String productId,
        @RequestParam(name = "priceList", required = false) String priceList,
        @RequestParam(name = "startDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startDate,
        @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endDate
    ) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("[PricesController][getPrices] Recibida nueva petición GET /prices");
        List<Price> response = pricesService.getPrices(productId, priceList, startDate, endDate);
        System.out.println("-----------------------------------------------------------------------");
        return response;
    }
}


