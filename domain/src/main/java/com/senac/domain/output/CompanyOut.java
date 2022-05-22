package com.senac.domain.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CompanyOut {
    private String id;
    private String name;
    private String address;
    private Double lat;
    private Double lon;
    private List<ServiceOut> services;
}
