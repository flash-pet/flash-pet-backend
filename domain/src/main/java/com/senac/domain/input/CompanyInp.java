package com.senac.domain.input;


import com.senac.domain.enums.DayTypeEn;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class CompanyInp {
    private String name;
    private String address;
    private Double lat;
    private Double lon;
    private List<ServiceInp> services;
    private OwnerInp owner;
    private Map<DayTypeEn, TimeInp> days;
    private List<ContactInp> contacts;
}
