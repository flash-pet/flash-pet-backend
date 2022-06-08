package com.senac.service.mapper;


import com.senac.domain.input.RateInp;
import com.senac.domain.output.IndividualRateOut;
import com.senac.infrastructure.entity.IndividualRate;

import java.time.LocalDate;
import java.util.UUID;

public class IndividualRateMapper {
    private IndividualRateMapper(){}

    public static final IndividualRate toEntity(RateInp rateInp) {
        return IndividualRate.builder()
                .id(UUID.randomUUID().toString())
                .date(LocalDate.now().toString())
                .description(rateInp.getDescription())
                .value(rateInp.getValue())
                .build();
    }

    public static final IndividualRateOut toOut(IndividualRate individualRate) {
        return IndividualRateOut.builder()
                .id(individualRate.getId())
                .value(individualRate.getValue())
                .description(individualRate.getDescription())
                .date(individualRate.getDate())
                .build();
    }
}
