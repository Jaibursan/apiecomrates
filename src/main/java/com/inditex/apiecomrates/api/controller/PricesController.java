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

/**
 * PricesController
 * This class is the controller used to process REST requests related to prices
 */
@RestController 
public class PricesController {
    
    @Autowired
    private PricesService pricesService;

    /**
     * getPrices
     * This method is used to get all prices
     * @return List of prices
     */
    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public List<Price> getPrices(
    ) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("[PricesController][getPrices] Recibida nueva petición GET /prices");
        List<Price> response = pricesService.getPrices();
        System.out.println("-----------------------------------------------------------------------");
        return response;
    }

    /**
     * getPricesPricetoapply
     * This method is used to get the price to apply
     * @param brandId
     * @param productId
     * @param date
     * @return Price to apply
     */
    @RequestMapping(value = "/prices/pricetoapply", method = RequestMethod.GET)
    public Price getPricesPricetoapply(
        @RequestParam(name = "brandId", required = false) String brandId,
        @RequestParam(name = "productId", required = false) String productId,
        @RequestParam(name = "date", required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date
    ) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("[PricesController][getPricesPriceToApply] Recibida nueva petición GET /prices/priceToApply");
        Price response = pricesService.getPricesPricetoapply(brandId, productId, date);
        System.out.println("-----------------------------------------------------------------------");
        return response;
    }
}


