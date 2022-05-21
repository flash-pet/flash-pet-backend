package com.senac.api.mapper;

import com.senac.domain.input.Filter;

public class FilterApiMapper {
    private FilterApiMapper(){}

    public static Filter toDomain(Integer pageNumber,
                           String serviceDescription,
                           String priceCategory) {
        return Filter.builder()
                .pageNumber(pageNumber)
                .serviceDescription(serviceDescription)
                .priceCategory(priceCategory).build();
    }
}
