package com.senac.domain.output;

import com.senac.domain.enums.ServiceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ServiceOut {
    private String id;
    private String description;
    private Double price;
    private ServiceType serviceType;
}
