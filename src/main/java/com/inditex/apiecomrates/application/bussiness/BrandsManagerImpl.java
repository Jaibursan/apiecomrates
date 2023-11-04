package com.inditex.apiecomrates.application.bussiness;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.apiecomrates.application.BrandsManager;
import com.inditex.apiecomrates.domain.model.Brand;
import com.inditex.apiecomrates.infrastructure.db.oraecom.converter.BrandsConverter;
import com.inditex.apiecomrates.infrastructure.db.oraecom.repository.BrandsRepository;

public class BrandsManagerImpl implements BrandsManager {
    
    @Autowired
    private BrandsRepository brandsRepository;
    
    @Autowired
    private BrandsConverter brandsConverter;

    @Override
    public List<Brand> execute() {
        long initTime = new Date().getTime();
        System.out.println("[BrandsManagerImpl][execute] Se lanza consulta de lista de marcas a la base de datos");
        List<Brand> result = brandsConverter.convert(brandsRepository.findAll());
        System.out.println("[BrandsManagerImpl][execute] Consulta completada ("+ (new Date().getTime() - initTime) + " ms)");
        return result;
	}

    @Override
    public Brand execute(String brandId) {
        long initTime = new Date().getTime();
        System.out.println("[BrandsManagerImpl][execute] Se lanza consulta de detalle de marca a la base de datos. Id: " + brandId);
        Brand result = brandsConverter.convert(brandsRepository.findById(brandId));
        System.out.println("[BrandsManagerImpl][execute] Consulta completada ("+ (new Date().getTime() - initTime) + " ms)");
        return result;
	}

}
