package com.inditex.apiecomrates.application.bussiness;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.apiecomrates.application.PricesManager;
import com.inditex.apiecomrates.domain.model.Price;
import com.inditex.apiecomrates.infrastructure.db.oraecom.converter.PricesConverter;
import com.inditex.apiecomrates.infrastructure.db.oraecom.repository.PricesRepository;

/**
 * PricesManagerImpl
 * This class contains the implementation of methods that execute the business logic related to prices
 */
public class PricesManagerImpl implements PricesManager {
    
    @Autowired
    private PricesRepository pricesRepository;
    
    @Autowired
    private PricesConverter pricesConverter;

    /**
     * execute
     * This method is used to get all prices
     * @return List of prices
     */
    @Override
    public List<Price> execute() {
        long initTime = new Date().getTime();
        System.out.println("[PricesManagerImpl][execute] Se lanza consulta de lista de tarifas a la base de datos");
        List<Price> result = pricesConverter.convert(pricesRepository.findAll());
        System.out.println("[PricesManagerImpl][execute] Consulta completada ("+ (new Date().getTime() - initTime) + " ms)");
        return result;
	}

    /**
     * execute
     * This method is used to get the price to apply by filters
     * @param brandId
     * @param productId
     * @param date
     * @return Price to apply
     */
    @Override
    public Price execute(String brandId, String productId, Date date) {
        long initTime = new Date().getTime();
        System.out.println("[PricesManagerImpl][execute] Se lanza consulta de tarifa a aplicar según filtros a la base de datos");
        Price result = pricesConverter.convert(pricesRepository.findFirstByProductPricelistAndDate(brandId, productId, date));
        System.out.println("[PricesManagerImpl][execute] Consulta completada ("+ (new Date().getTime() - initTime) + " ms)");
        return result;
	}

}
