package com.senac.api.mapper;

import com.senac.api.dto.Service;
import com.senac.domain.enums.ServiceType;
import com.senac.domain.input.ServiceInp;
import com.senac.domain.output.ServiceOut;

public class ServiceApiMapper {
    private ServiceApiMapper(){}

    public static Service toResponse(ServiceOut serviceOut) {
        final Service service = new Service();
        service.setDescription(serviceOut.getDescription());
        service.setId(serviceOut.getId());
        service.setPrice(serviceOut.getPrice());
        service.setServiceType(serviceOut.getServiceType().toString().toLowerCase());
        return service;
    }

    public static ServiceInp toDomain(Service service) {
        return ServiceInp.builder()
                .description(service.getDescription())
                .price(service.getPrice())
                .serviceType(ServiceType.valueOf(service.getServiceType().toUpperCase()))
                .build();
    }
}
