package com.senac.domain.output;

import com.senac.domain.enums.DayTypeEn;
import com.senac.domain.input.ContactInp;
import com.senac.domain.input.OwnerInp;
import com.senac.domain.input.ServiceInp;
import com.senac.domain.input.TimeInp;
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
}
