package com.senac.api.mapper;

import com.senac.api.dto.IndividualRate;
import com.senac.domain.input.RateInp;
import com.senac.domain.output.IndividualRateOut;

public class IndividualRateApiMapper {
    private IndividualRateApiMapper(){}

    public static final IndividualRate toResponse(IndividualRateOut individualRateOut) {
        final IndividualRate individualRate = new IndividualRate();
        individualRate.setDate(individualRateOut.getDate());
        individualRate.setDescription(individualRateOut.getDescription());
        individualRate.setValue(individualRateOut.getValue());
        return individualRate;
    }

    public static final RateInp toDomain(IndividualRate individualRate) {
        return RateInp.builder()
                .description(individualRate.getDescription())
                .value(individualRate.getValue())
                .build();
    }
}
