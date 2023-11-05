package com.inditex.apiecomrates.infrastructure.db.oraecom.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inditex.apiecomrates.infrastructure.db.oraecom.entity.PricesEntity;
import com.inditex.apiecomrates.infrastructure.db.oraecom.entity.PricesIdEntity;

@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, PricesIdEntity> {
    
    public List<PricesEntity> findAll();
    
    @Query(
        value = "SELECT * FROM PRICES WHERE (?1 IS NULL OR BRAND_ID = ?1) AND (?2 IS NULL OR PRODUCT_ID = ?2) AND (?3 IS NULL OR ?3 BETWEEN START_DATE AND END_DATE) ORDER BY PRIORITY DESC LIMIT 1", 
        nativeQuery = true)
    public Optional<PricesEntity> findFirstByProductPricelistAndDate(String brandId, String productId, Date date);
}