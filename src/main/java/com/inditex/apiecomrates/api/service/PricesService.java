package com.inditex.apiecomrates.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.apiecomrates.application.PricesManager;
import com.inditex.apiecomrates.domain.model.Price;

@Service
public class PricesService {
    
    @Autowired
    private PricesManager pricesManager;
    
    public List<Price> getPrices() {
        System.out.println("[PricesService][getPrices] INICIO");
        List<Price> response = pricesManager.execute();
        System.out.println("[PricesService][getPrices] Se han encontrado " + (response != null ? response.size() : 0) + " resultados");
        System.out.println("[PricesService][getPrices] FIN");
        return response; 
    }

    public Price getPricesPriceToApply(String productId, String priceList, Date date) {
        System.out.println("[PricesService][getPricesPriceToApply] INICIO");
        String params = "";
        if (productId != null) params += "productId = " + productId + ", ";
        if (priceList != null) params += "priceList = " + priceList + ", ";
        if (date != null) params += "date = " + date + ", ";
        params = (params == "") ? "No hay parámetros de entrada" : params.substring(0, params.length() - 2);
        System.out.println("[PricesService][getPricesPriceToApply] Parámetros de entrada: " + params);
        Price response = pricesManager.execute(productId, priceList, date);
        System.out.println("[PricesService][getPricesPriceToApply] " + ((response != null) ? "Tarifa encontrada" : "No se ha encontrado ninguna tarifa"));
        System.out.println("[PricesService][getPricesPriceToApply] FIN");
        return response; 
    }
}
