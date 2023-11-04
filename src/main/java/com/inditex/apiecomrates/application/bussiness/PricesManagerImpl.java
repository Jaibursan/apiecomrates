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
        // Lógica para probar los dos tipos de accesos, mediante función JPA y mediante @query
        List<Price> result;
        long initTime = new Date().getTime();
        if (productId == null && priceList == null && startDate == null && endDate == null) {
            System.out.println("[PricesManagerImpl] Se lanza consulta sin filtros a la base de datos");
            result = pricesConverter.convert(pricesRepository.findAll());
        } else {
            System.out.println("[PricesManagerImpl] Se lanza consulta con filtros a la base de datos");
            result = pricesConverter.convert(pricesRepository.findAllWithFilters(productId, priceList, startDate, endDate));
        }
        System.out.println("[PricesManagerImpl] Consulta completada ("+ (new Date().getTime() - initTime) + " ms)");
        return result;
	}

}
