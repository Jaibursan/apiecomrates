package com.inditex.apiecomrates.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.apiecomrates.application.PricesManager;
import com.inditex.apiecomrates.application.bussiness.PricesManagerImpl;
import com.inditex.apiecomrates.infrastructure.db.oraecom.converter.PricesConverter;
import com.inditex.apiecomrates.infrastructure.db.oraecom.repository.PricesRepository;

/**
 * PricesConfiguration
 * This class contains the beans used to process requests related to prices
 */
@Configuration
public class PricesConfiguration {

    // Los @Controller, @Service, y @Repository no se añaden a esta clase como Beans porque ya se añaden al contenedor de Spring por sí solos.

    @Bean
    public PricesManager pricesManager(PricesRepository pricesRepository, PricesConverter pricesConverter) {
        return new PricesManagerImpl();
    }

    @Bean
    public PricesConverter pricesConverter() {
        return new PricesConverter();
    }
}


