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
        company.setLatitude(companyOut.getLat());
        company.setLongitude(companyOut.getLon());
        company.setServices(companyOut.getServices().stream().map(ServiceApiMapper::toResponse).collect(Collectors.toList()));
        company.setContact(ContactApiMapper.toResponse(companyOut.getContacts()));
        company.setDays(DayApiMapper.toResponse(companyOut.getDays()));
        company.setOwner(OwnerApiMapper.toResponse(companyOut.getOwner()));
        return company;
    }

    public static final CompanyInp toDomain(Company company) {
        return CompanyInp.builder()
                .name(company.getName())
                .address(company.getAddress())
                .lat(company.getLatitude())
                .lon(company.getLongitude())
                .services(company.getServices().stream().map(ServiceApiMapper::toDomain).collect(Collectors.toList()))
                .owner(OwnerApiMapper.toDomain(company.getOwner()))
                .days(DayApiMapper.toDomain(company.getDays()))
                .contacts(ContactApiMapper.toDomain(company.getContact()))
                .build();
    }
}
