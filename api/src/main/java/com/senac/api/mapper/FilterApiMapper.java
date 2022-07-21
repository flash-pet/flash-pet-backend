package com.senac.api.mapper;


import com.senac.domain.dto.Filter;

import java.util.List;

public class FilterApiMapper {
    private FilterApiMapper(){}

    public static Filter toDomain(String serviceDescription,
                                  List<Object> priceCategory,
                                  List<String> serviceType,
                                  Double latitude,
                                  Double longitude,
                                  List<String> day,
                                  Integer rate,
                                  Integer rateFinal) {
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
