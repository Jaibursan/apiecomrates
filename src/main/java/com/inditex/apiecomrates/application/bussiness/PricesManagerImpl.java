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
    public List<Price> execute() {
        long initTime = new Date().getTime();
        System.out.println("[PricesManagerImpl][execute] Se lanza consulta de lista de tarifas a la base de datos");
        List<Price> result = pricesConverter.convert(pricesRepository.findAll());
        System.out.println("[PricesManagerImpl][execute] Consulta completada ("+ (new Date().getTime() - initTime) + " ms)");
        return result;
	}

    @Override
    public Price execute(String productId, String priceList, Date date) {
        long initTime = new Date().getTime();
        System.out.println("[PricesManagerImpl][execute] Se lanza consulta de tarifa a aplicar según filtros a la base de datos");
        Price result = pricesConverter.convert(pricesRepository.findFirstByProductPricelistAndDate(productId, priceList, date));
        System.out.println("[PricesManagerImpl][execute] Consulta completada ("+ (new Date().getTime() - initTime) + " ms)");
        return result;
	}

}
