package com.senac.service.mapper;


import com.senac.domain.input.RateInp;
import com.senac.domain.output.IndividualRateOut;
import com.senac.infrastructure.entity.IndividualRate;

import java.time.LocalDate;
import java.util.UUID;

public class IndividualRateMapper {
    private IndividualRateMapper(){}

    public static final IndividualRate toEntity(RateInp rateInp) {
        if(rateInp == null) return null;
        return IndividualRate.builder()
                .date(LocalDate.now().toString())
                .description(rateInp.getDescription())
                .value(rateInp.getValue())
                .build();
    }

    public static final IndividualRateOut toOut(IndividualRate individualRate) {
        if(individualRate == null) return null;
        return IndividualRateOut.builder()
                .id(individualRate.getId())
                .value(individualRate.getValue())
                .description(individualRate.getDescription())
                .date(individualRate.getDate())
                .build();
    }
}
