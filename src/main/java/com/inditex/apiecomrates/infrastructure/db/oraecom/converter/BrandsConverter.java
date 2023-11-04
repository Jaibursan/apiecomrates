package com.inditex.apiecomrates.infrastructure.db.oraecom.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inditex.apiecomrates.domain.model.Brand;
import com.inditex.apiecomrates.infrastructure.db.oraecom.entity.BrandsEntity;

public class BrandsConverter {

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

    public Brand convert(Optional<BrandsEntity> source) {
        if (source.isPresent()) {
            BrandsEntity brandEntity = source.get();
            return new Brand(
                brandEntity.getBrandId(),
                brandEntity.getBrandName(),
                brandEntity.getNif(),
                brandEntity.getAddress(),
                brandEntity.getCnaeCode()
            );
        }
        return null;
    }
}
