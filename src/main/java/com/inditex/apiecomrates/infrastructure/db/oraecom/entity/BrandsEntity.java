package com.inditex.apiecomrates.infrastructure.db.oraecom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BRANDS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandsEntity {
    
	@Id 
    @Column(name = "BRAND_ID")
	private String brandId;

	@Column(name = "BRAND_NAME")
	private String brandName;

}
