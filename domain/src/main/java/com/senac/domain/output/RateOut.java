package com.senac.domain.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RateOut {
    private String id;
    private double avg;
    private List<IndividualRateOut> rates;
}
