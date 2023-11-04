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
    
    public List<Price> getPrices(String productId, String priceList, Date startDate, Date endDate) {
        System.out.println("[PricesService] INICIO");
        String params = "";
        if (productId != null) params += "productId = " + productId + ", ";
        if (priceList != null) params += "priceList = " + priceList + ", ";
        if (startDate != null) params += "startDate = " + startDate + ", ";
        if (endDate != null) params += "endate = " + endDate + ", ";
        params = (params == "") ? "No hay parámetros de entrada" : params.substring(0, params.length() - 2);
        System.out.println("[PricesService] Parámetros de entrada: " + params);
        
        List<Price> response = pricesManager.execute(productId, priceList, startDate, endDate);

        System.out.println("[PricesService] Se han encontrado " + (response != null ? response.size() : 0) + " resultados");
        System.out.println("[PricesService] FIN");
        return response; 
    }
}
