package com.senac.domain.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TimeInp {
    private String start;
    private String end;
}
