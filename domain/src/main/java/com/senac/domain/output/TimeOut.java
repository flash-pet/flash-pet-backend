package com.senac.domain.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TimeOut {
    private String start;
    private String end;
}
