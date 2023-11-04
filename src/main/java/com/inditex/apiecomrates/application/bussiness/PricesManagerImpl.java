package com.inditex.apiecomrates.application.bussiness;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.apiecomrates.application.PricesManager;
import com.inditex.apiecomrates.domain.model.Price;
import com.inditex.apiecomrates.infrastructure.db.oraecom.converter.PricesConverter;
import com.inditex.apiecomrates.infrastructure.db.oraecom.repository.PricesRepository;

public class PricesManagerImpl implements PricesManager {
    
    @Autowired
    private PricesRepository pricesRepository;
    
    @Autowired
    private PricesConverter pricesConverter;

    @Override
    public List<Price> execute(String productId, String priceList, Date startDate, Date endDate) {
        long initTime = new Date().getTime();
        System.out.println("[PricesManagerImpl][execute] Se lanza consulta de lista de tarifas con filtros a la base de datos");
        List<Price> result;
        // Lógica para probar los dos tipos de accesos, mediante función JPA y mediante @query
        if (productId == null && priceList == null && startDate == null && endDate == null) {
            result = pricesConverter.convert(pricesRepository.findAll());
        } else {
            result = pricesConverter.convert(pricesRepository.findAllWithFilters(productId, priceList, startDate, endDate));
        }
        System.out.println("[PricesManagerImpl][execute] Consulta completada ("+ (new Date().getTime() - initTime) + " ms)");
        return result;
	}

}
