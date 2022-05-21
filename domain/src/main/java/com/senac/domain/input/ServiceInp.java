package com.senac.domain.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ServiceInp {
    private String description;
    private Double price;
}
