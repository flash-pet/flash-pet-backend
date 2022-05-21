package com.senac.api.mapper;

import com.senac.api.dto.Company;
import com.senac.domain.input.CompanyInp;
import com.senac.domain.output.CompanyOut;

import java.util.stream.Collectors;

public class CompanyApiMapper {
    private CompanyApiMapper(){}

    public static final Company toResponse(CompanyOut companyOut) {
        final Company company = new Company();
        company.setId(companyOut.getId());
        company.setName(companyOut.getName());
        company.setAddress(companyOut.getAddress());
        company.setServices(companyOut.getServices().stream().map(ServiceApiMapper::toResponse).collect(Collectors.toList()));
        return null;
    }

    public static final CompanyInp toDomain(Company company) {
        return CompanyInp.builder()
                .name(company.getName())
                .address(company.getAddress())
                .services(company.getServices().stream().map(ServiceApiMapper::toDomain).collect(Collectors.toList()))
                .build();
    }
}
