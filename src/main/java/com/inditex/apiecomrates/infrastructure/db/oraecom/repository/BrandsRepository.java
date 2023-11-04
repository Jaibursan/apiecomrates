package com.inditex.apiecomrates.infrastructure.db.oraecom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inditex.apiecomrates.infrastructure.db.oraecom.entity.BrandsEntity;

@Repository
public interface BrandsRepository extends JpaRepository<BrandsEntity, String> {
    
    public List<BrandsEntity> findAll();

    public Optional<BrandsEntity> findById(String brandId);
}