package com.inditex.apiecomrates.infrastructure.db.oraecom.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inditex.apiecomrates.infrastructure.db.oraecom.entity.PricesEntity;
import com.inditex.apiecomrates.infrastructure.db.oraecom.entity.PricesIdEntity;

@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, PricesIdEntity> {
    
    public List<PricesEntity> findAll();
    
    @Query(
        value = "SELECT * FROM PRICES WHERE (?1 IS NULL OR PRODUCT_ID = ?1) AND (?2 IS NULL OR PRICE_LIST = ?2) AND (?3 IS NULL OR START_DATE >= ?3) AND (?4 IS NULL OR END_DATE <= ?4) ORDER BY PRIORITY DESC", 
        nativeQuery = true)
    public List<PricesEntity>  findAllWithFilters(String productId, String priceList, Date startDate, Date endDate);
}