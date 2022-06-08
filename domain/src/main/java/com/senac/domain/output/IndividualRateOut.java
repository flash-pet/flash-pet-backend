package com.senac.domain.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IndividualRateOut {
    private String id;
    private Integer value;
    private String description;
    private String date;
}
