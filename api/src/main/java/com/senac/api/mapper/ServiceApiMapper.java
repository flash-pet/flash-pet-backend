//package com.senac.api.mapper;
//
//import com.senac.api.dto.Service;
//import com.senac.domain.enums.ServiceType;
//import com.senac.domain.input.ServiceInp;
//import com.senac.domain.output.ServiceOut;
//
//public class ServiceApiMapper {
//    private ServiceApiMapper(){}
//
//    public static Service toResponse(ServiceOut serviceOut) {
//        if (serviceOut == null) return null;
//        final Service service = new Service();
//        service.setDescription(serviceOut.getDescription());
//        service.setId(serviceOut.getId());
//        service.setPrice(serviceOut.getPrice());
//        service.setServiceType(serviceOut.getServiceType().toString().toLowerCase());
//        service.setImage(serviceOut.getImage());
//        return service;
//    }
//
//    public static ServiceInp toDomain(Service service) {
//        if(service == null) return null;
//        return ServiceInp.builder()
//                .id(service.getId())
//                .description(service.getDescription())
//                .price(service.getPrice())
//                .serviceType(ServiceType.valueOf(service.getServiceType().toUpperCase()))
//                .build();
//    }
//}
