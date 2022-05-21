package com.senac.service.mapper;

import com.senac.domain.input.ServiceInp;
import com.senac.domain.output.ServiceOut;
import com.senac.infrastructure.entity.ServiceC;

import java.util.UUID;

public class ServiceMapper {
    private ServiceMapper(){}

    public static final ServiceC toEntity(ServiceInp serviceInp) {
        return ServiceC.builder()
                .id(UUID.randomUUID().toString())
                .description(serviceInp.getDescription())
                .price(serviceInp.getPrice()).build();
    }

    public static final ServiceOut toOut(ServiceC serviceC) {
        return ServiceOut.builder()
                .id(serviceC.getId())
                .description(serviceC.getDescription())
                .price(serviceC.getPrice()).build();
    }
}
