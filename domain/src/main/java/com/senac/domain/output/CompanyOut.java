package com.senac.domain.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class CompanyOut {
    private String id;
    private String name;
    private String address;
    private List<ServiceOut> services;
}
