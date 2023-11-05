package com.inditex.apiecomrates.application.bussiness;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.apiecomrates.application.BrandsManager;
import com.inditex.apiecomrates.domain.model.Brand;
import com.inditex.apiecomrates.exceptions.NoSuchElementFoundException;
import com.inditex.apiecomrates.infrastructure.db.oraecom.converter.BrandsConverter;
import com.inditex.apiecomrates.infrastructure.db.oraecom.entity.BrandsEntity;
import com.inditex.apiecomrates.infrastructure.db.oraecom.repository.BrandsRepository;

/**
 * BrandsManagerImpl
 * This class contains the implementation of methods that execute the business logic related to brands
 */
public class BrandsManagerImpl implements BrandsManager {
    
    @Autowired
    private BrandsRepository brandsRepository;
    
    @Autowired
    private BrandsConverter brandsConverter;

    /**
     * execute
     * This method is used to get all brands
     * @return List of brands
     */
    @Override
    public List<Brand> execute() {
        long initTime = new Date().getTime();
        System.out.println("[BrandsManagerImpl][execute] Se lanza consulta de lista de marcas a la base de datos");
        List<Brand> result = brandsConverter.convert(brandsRepository.findAll());
        System.out.println("[BrandsManagerImpl][execute] Consulta completada ("+ (new Date().getTime() - initTime) + " ms)");
        return result;
	}

    /**
     * execute
     * This method is used to get the brand detail, searching by id
     * @param brandId
     * @return Brand detail
     */
    @Override
    public Brand execute(String brandId) {
        long initTime = new Date().getTime();
        System.out.println("[BrandsManagerImpl][execute] Se lanza consulta de detalle de marca a la base de datos. Id: " + brandId);
        Optional<BrandsEntity> optionalBrandsEntity = brandsRepository.findById(brandId);
        if (!optionalBrandsEntity.isPresent()) {
            throw new NoSuchElementFoundException("No se ha encontrado ninguna marca con el id indicado");
        }
        Brand result = brandsConverter.convert(optionalBrandsEntity.get());
        System.out.println("[BrandsManagerImpl][execute] Consulta completada ("+ (new Date().getTime() - initTime) + " ms)");
        return result;
	}

}
