package com.inditex.apiecomrates.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.apiecomrates.application.BrandsManager;
import com.inditex.apiecomrates.application.bussiness.BrandsManagerImpl;
import com.inditex.apiecomrates.infrastructure.db.oraecom.converter.BrandsConverter;
import com.inditex.apiecomrates.infrastructure.db.oraecom.repository.BrandsRepository;

/**
 * BrandsConfiguration
 * This class contains the beans used to process requests related to brands
 */
@Configuration
public class BrandsConfiguration {

    // Los @Controller, @Service, y @Repository no se añaden a esta clase como Beans porque ya se añaden al contenedor de Spring por sí solos.

    @Bean
    public BrandsManager brandsManager(BrandsRepository brandsRepository, BrandsConverter brandsConverter) {
        return new BrandsManagerImpl();
    }

    @Bean
    public BrandsConverter brandsConverter() {
        return new BrandsConverter();
    }

}


