package com.senac.service.mapper;

import com.senac.domain.input.CompanyInp;
import com.senac.domain.input.ServiceInp;
import com.senac.domain.output.CompanyOut;
import com.senac.domain.output.ServiceOut;
import com.senac.infrastructure.entity.Company;
import com.senac.infrastructure.entity.Rate;
import com.senac.infrastructure.entity.ServiceC;
import com.senac.infrastructure.enums.PriceCategory;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CompanyMapper {
    private CompanyMapper(){}

    public static final Company toEntity(CompanyInp companyInp) {
        return Company.builder()
                .id(companyInp.getId() == null ? UUID.randomUUID().toString() : companyInp.getId())
                .name(companyInp.getName())
                .address(companyInp.getAddress())
                .location(geoPointToEntity(companyInp.getLat(), companyInp.getLon()))
                .services(serviceToEntity(companyInp.getServices()))
                .owner(OwnerMapper.toEntity(companyInp.getOwner()))
                .days(DayMapper.toEntity(companyInp.getDays()))
                .contacts(ContactMapper.toEntity(companyInp.getContacts()))
                .logo(companyInp.getLogo())
                .carrosel(companyInp.getCarrosel())
                .build();
    }

    public static final CompanyOut toOut(Company company) {
        return CompanyOut.builder()
                .id(company.getId())
                .name(company.getName())
                .address(company.getAddress())
                .lat(company.getLocation().getLat())
                .lon(company.getLocation().getLon())
                .services(serviceToOut(company.getServices()))
                .owner(OwnerMapper.toOut(company.getOwner()))
                .days(DayMapper.toOut(company.getDays()))
                .contacts(ContactMapper.toOut(company.getContacts()))
                .rate(RateMapper.toOut(company.getRate()))
                .logo(company.getLogo())
                .carrosel(company.getCarrosel())
                .build();
    }

    private static final GeoPoint geoPointToEntity(Double lat, Double lon) {
        if(lat == null || lon == null) return null;
        return new GeoPoint(lat, lon);
    }

    private static final List<ServiceOut> serviceToOut(List<ServiceC> serviceC) {
        if(serviceC == null) return null;
        return serviceC.stream().map(ServiceMapper::toOut).collect(Collectors.toList());
    }

    private static final List<ServiceC> serviceToEntity(List<ServiceInp> serviceInps) {
        if(serviceInps == null) return null;
        return serviceInps.stream().map(ServiceMapper::toEntity).collect(Collectors.toList());
    }
}
