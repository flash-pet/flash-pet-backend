package com.senac.api.route;

import com.senac.api.dto.CacheRate;
import com.senac.api.dto.Company;
import com.senac.api.dto.IndividualRate;
import com.senac.api.mapper.CacheExpirationApiMapper;
import com.senac.api.mapper.CompanyApiMapper;
import com.senac.api.mapper.FilterApiMapper;
import com.senac.api.mapper.IndividualRateApiMapper;
import com.senac.domain.input.Filter;
import com.senac.domain.output.CompanyGetAllOut;
import com.senac.security.utils.JwtTokenUtil;
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
    private static final String HEADER_SCROLL_ID = "X-Sroll-id";

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
    public ResponseEntity<List<Company>> findCompanies(String serviceDescription,
                                                       String priceCategory,
                                                       String serviceType,
                                                       Double latitude,
                                                       Double longitude,
                                                       String day,
                                                       Integer rate) {
        final Filter filter = FilterApiMapper.toDomain(serviceDescription, priceCategory, serviceType, latitude, longitude, day, rate);

        final CompanyGetAllOut companyGetAllOut = companyService.getAll(filter);

        final List<Company> companyList = companyGetAllOut.getCompanies()
                .stream().map(CompanyApiMapper::toResponse).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .header(HEADER_SCROLL_ID, companyGetAllOut.getScrollId())
                .body(companyList);
    }

    @Override
    public ResponseEntity<List<Company>> findCompaniesByScroll(String scroll) {
        final CompanyGetAllOut companyGetAllOut = companyService.getByScroll(scroll);

        final List<Company> companyList = companyGetAllOut.getCompanies()
                .stream().map(CompanyApiMapper::toResponse).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .header(HEADER_SCROLL_ID, companyGetAllOut.getScrollId())
                .body(companyList);
    }

    @Override
    public ResponseEntity<Void> addRate(String companyId, String cacheCode, IndividualRate body) {
         companyService.addRate(companyId, cacheCode, IndividualRateApiMapper.toDomain(body));
         return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CacheRate> getRate(String companyId) {
        return ResponseEntity.ok(CacheExpirationApiMapper.toResponse(companyService.generateRate(companyId)));
    }
}
