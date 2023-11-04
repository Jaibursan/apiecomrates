package com.inditex.apiecomrates.infrastructure.db.oraecom.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class PricesIdEntity implements Serializable {
    
	@ManyToOne
	@JoinColumn(name = "BRAND_ID")
	private BrandsEntity brandsEntity;

	@Column(name = "PRODUCT_ID")
	private String productId;
	
	@Column(name = "PRICE_LIST")
	private String priceList;

}
