package com.inditex.apiecomrates.infrastructure.db.oraecom.converter;

import java.util.ArrayList;
import java.util.List;

import com.inditex.apiecomrates.domain.model.Price;
import com.inditex.apiecomrates.infrastructure.db.oraecom.entity.PricesEntity;
import com.inditex.apiecomrates.domain.model.Money;

/**
 * PricesConverter
 * This class contains the logic to convert from DAO objects to DTO objects related to prices
 */
public class PricesConverter {

    /**
     * convert
     * This method converts a list of PricesEntity to a list of Price
     * @param source List of PricesEntity
     * @return List of Price
     */
    public List<Price> convert(List<PricesEntity> source) {
        
        List<Price> listPrice = new ArrayList<Price>();
        source.stream().forEach(pricesEntity -> {
            listPrice.add(new Price(
                pricesEntity.getPricesIdEntity().getProductId(),
                pricesEntity.getPricesIdEntity().getBrandsEntity().getBrandId(),
                pricesEntity.getPricesIdEntity().getPriceList(),
                pricesEntity.getStartDate(),
                pricesEntity.getEndDate(),
                new Money(
                    pricesEntity.getPrice(),
                    pricesEntity.getCurr()
                )
            ));
        });
        return listPrice;
    }

    /**
     * convert
     * This method converts a PricesEntity to a Price
     * @param source Object PricesEntity
     * @return Object Price
     */
    public Price convert(PricesEntity source) {
        if (source != null) {
            return new Price(
                source.getPricesIdEntity().getProductId(),
                source.getPricesIdEntity().getBrandsEntity().getBrandId(),
                source.getPricesIdEntity().getPriceList(),
                source.getStartDate(),
                source.getEndDate(),
                new Money(
                    source.getPrice(),
                    source.getCurr()
                )
            );
        }
        return null;
    }
}
