package com.inditex.apiecomrates.infrastructure.db.oraecom.converter;

import java.util.ArrayList;
import java.util.List;

import com.inditex.apiecomrates.domain.model.Brand;
import com.inditex.apiecomrates.infrastructure.db.oraecom.entity.BrandsEntity;

/**
 * BrandsConverter
 * This class contains the logic to convert from DAO objects to DTO objects related to brands
 */
public class BrandsConverter {

    /**
     * convert
     * This method converts a list of BrandsEntity to a list of Brands
     * @param source List of BrandsEntity
     * @return List of Brand
     */
    public List<Brand> convert(List<BrandsEntity> source) {
        
        List<Brand> listBrand = new ArrayList<Brand>();
        source.stream().forEach(brandsEntity -> {
            listBrand.add(new Brand(
                brandsEntity.getBrandId(),
                brandsEntity.getBrandName()
            ));
        });
        return listBrand;
    }

    /**
     * convert
     * This method converts a BrandsEntity to a Brand
     * @param source Object BrandsEntity
     * @return Object Brand
     */
    public Brand convert(BrandsEntity source) {
        if (source != null) {
            return new Brand(
                source.getBrandId(),
                source.getBrandName(),
                source.getNif(),
                source.getAddress(),
                source.getCnaeCode()
            );
        }
        return null;
    }
}
