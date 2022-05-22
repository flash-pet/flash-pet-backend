package com.senac.service.mapper;

import com.senac.domain.output.CompanyGetAllOut;
import com.senac.domain.output.CompanyOut;

import java.util.List;

public class CompanyGetAllMapper {
    private CompanyGetAllMapper(){}

    public static final CompanyGetAllOut toOut(String scrollId, List<CompanyOut> companies) {
        return CompanyGetAllOut.builder()
                .scrollId(scrollId)
                .companies(companies).build();
    }
}
