package com.inditex.apiecomrates.infrastructure.db.oraecom.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRICES")
@Data
public class PricesEntity {
    
	@EmbeddedId 
    private PricesIdEntity pricesIdEntity;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

    @Column(name = "PRIORITY")
	private Integer priority;

    @Column(name = "PRICE")
	private BigDecimal price;

    @Column(name = "CURR")
	private String curr;

}
