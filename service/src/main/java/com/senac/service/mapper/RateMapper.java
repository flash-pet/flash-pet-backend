package com.senac.service.mapper;

import com.senac.domain.output.RateOut;
import com.senac.infrastructure.entity.IndividualRate;
import com.senac.infrastructure.entity.Rate;

import java.util.stream.Collectors;


public class RateMapper {
    private RateMapper() {}

    public static final RateOut toOut(Rate rate) {
        if(rate == null) return null;
        return RateOut.builder()
                .id(rate.getId() == null ? null : rate.getId())
                .avg(rate.getAvg())
                .rates(rate.getIndividualRates().stream().map(IndividualRateMapper::toOut)
                        .collect(Collectors.toList()))
                .build();
    }
}
