package com.senac.service.mapper;

import com.senac.domain.input.CompanyInp;
import com.senac.domain.output.CompanyOut;
import com.senac.infrastructure.entity.Company;
import com.senac.infrastructure.enums.PriceCategory;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.UUID;
import java.util.stream.Collectors;

public class CompanyMapper {
    private CompanyMapper(){}

    public static final Company toEntity(CompanyInp companyInp) {
        return Company.builder()
                .id(UUID.randomUUID().toString())
                .name(companyInp.getName())
                .address(companyInp.getAddress())
                .location(new GeoPoint(companyInp.getLat(), companyInp.getLon()))
                .services(companyInp.getServices().stream().map(ServiceMapper::toEntity).collect(Collectors.toList()))
                .build();
    }

    public static final CompanyOut toOut(Company company) {
        return CompanyOut.builder()
                .id(company.getId())
                .name(company.getName())
                .address(company.getAddress())
                .lat(company.getLocation().getLat())
                .lon(company.getLocation().getLon())
                .services(company.getServices().stream().map(ServiceMapper::toOut).collect(Collectors.toList()))
                .build();
    }
}
