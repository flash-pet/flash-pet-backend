package com.senac.api.mapper;

import com.senac.api.dto.IndividualRate;
import com.senac.domain.input.RateInp;
import com.senac.domain.output.IndividualRateOut;

public class IndividualRateApiMapper {
    private IndividualRateApiMapper(){}

    public static final IndividualRate toResponse(IndividualRateOut individualRateOut) {
        if(individualRateOut == null) return null;
        final IndividualRate individualRate = new IndividualRate();
        individualRate.setDate(individualRateOut.getDate());
        individualRate.setDescription(individualRateOut.getDescription());
        individualRate.setValue(individualRateOut.getValue());
        return individualRate;
    }

    public static final RateInp toDomain(IndividualRate individualRate) {
        if(individualRate == null) return null;
        return RateInp.builder()
                .description(individualRate.getDescription())
                .value(individualRate.getValue())
                .build();
    }
}
