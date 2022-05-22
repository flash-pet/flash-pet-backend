package com.senac.domain.input;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CompanyInp {
    private String name;
    private String address;
    private Double lat;
    private Double lon;
    private List<ServiceInp> services;
}
