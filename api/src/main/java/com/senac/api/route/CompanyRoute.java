package com.senac.api.route;

import com.senac.api.dto.Company;
import com.senac.api.mapper.CompanyApiMapper;
import com.senac.api.mapper.FilterApiMapper;
import com.senac.infrastructure.enums.PriceCategory;
import com.senac.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CompanyRoute implements CompaniesApiDelegate {

    private final CompanyService companyService;

    @Override
    public ResponseEntity<Company> addCompany(Company body) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CompanyApiMapper.toResponse(
                        companyService.add(CompanyApiMapper.toDomain(body)))
                );
    }

    @Override
    public ResponseEntity<Company> updateCompany(Company body) {
        return ResponseEntity.ok(CompanyApiMapper.toResponse(
                companyService.update(CompanyApiMapper.toDomain(body))
        ));
    }

    @Override
    public ResponseEntity<List<Company>> findCompanies(Integer pageNumber, String serviceDescription, String priceCategory) {
        return ResponseEntity.ok(companyService.getAll(FilterApiMapper.toDomain(pageNumber, serviceDescription, priceCategory))
                        .stream().map(CompanyApiMapper::toResponse).collect(Collectors.toList()));
    }
}
