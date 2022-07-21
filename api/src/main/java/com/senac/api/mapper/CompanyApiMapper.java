//package com.senac.api.mapper;
//
//import com.senac.api.dto.Company;
//import com.senac.api.dto.Service;
//import com.senac.domain.input.CompanyInp;
//import com.senac.domain.input.ServiceInp;
//import com.senac.domain.output.CompanyOut;
//import com.senac.domain.output.ServiceOut;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class CompanyApiMapper {
//    private CompanyApiMapper(){}
//
//    public static final Company toResponse(CompanyOut companyOut) {
//        final Company company = new Company();
//        company.setId(companyOut.getId());
//        company.setName(companyOut.getName());
//        company.setAddress(companyOut.getAddress());
//        company.setLatitude(companyOut.getLat());
//        company.setLongitude(companyOut.getLon());
//        company.setServices(serviceToResponse(companyOut.getServices()));
//        company.setContact(ContactApiMapper.toResponse(companyOut.getContacts()));
//        company.setDays(DayApiMapper.toResponse(companyOut.getDays()));
//        company.setOwner(OwnerApiMapper.toResponse(companyOut.getOwner()));
//        company.setRate(RateApiMapper.toResponse(companyOut.getRate()));
//        company.setLogo(companyOut.getLogo());
//        company.setCarrosel(companyOut.getCarrosel());
//        return company;
//    }
//
//    public static final CompanyInp toDomain(Company company) {
//        return CompanyInp.builder()
//                .id(company.getId())
//                .name(company.getName())
//                .address(company.getAddress())
//                .lat(company.getLatitude())
//                .lon(company.getLongitude())
//                .services(serviceToDomain(company.getServices()))
//                .owner(OwnerApiMapper.toDomain(company.getOwner()))
//                .days(DayApiMapper.toDomain(company.getDays()))
//                .contacts(ContactApiMapper.toDomain(company.getContact()))
//                .logo(company.getLogo())
//                .carrosel(company.getCarrosel())
//                .build();
//    }
//
//    private static final List<ServiceInp> serviceToDomain(List<Service> service) {
//        if (service == null) return null;
//        return service.stream().map(ServiceApiMapper::toDomain).collect(Collectors.toList());
//    }
//
//    private static final List<Service> serviceToResponse(List<ServiceOut> service) {
//        if(service == null) return null;
//        return service.stream().map(ServiceApiMapper::toResponse).collect(Collectors.toList());
//    }
//}
