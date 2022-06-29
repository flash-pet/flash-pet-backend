package com.senac.domain.output;

import com.senac.domain.enums.DayTypeEn;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

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
    private OwnerOut owner;
    private Map<DayTypeEn, TimeOut> days;
    private List<ContactOut> contacts;
    private RateOut rate;
    private String logo;
    private List<String> carrosel;
}
