package com.senac.api.mapper;

import com.senac.domain.input.Filter;

public class FilterApiMapper {
    private FilterApiMapper(){}

    public static Filter toDomain(String serviceDescription,
                                  String priceCategory,
                                  String serviceType,
                                  Double latitude,
                                  Double longitude,
                                  String day,
                                  Integer rate) {
        return Filter.builder()
                .serviceDescription(serviceDescription)
                .serviceType(serviceType)
                .priceCategory(priceCategory)
                .lat(latitude)
                .lon(longitude)
                .day(day)
                .rate(rate)
                .build();
    }
}
