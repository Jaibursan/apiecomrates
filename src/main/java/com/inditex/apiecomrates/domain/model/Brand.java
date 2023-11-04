package com.inditex.apiecomrates.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Brand {
    
    private String brandId;

	private String brandName;

    private String nif;

    private String address;

    private String cnaeCode;

    public Brand(String brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }
}
