package com.senac.domain.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RateInp {
    private Integer value;
    private String date;
    private String  description;
}
