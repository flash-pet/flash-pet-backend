package com.senac.api.route;


import com.senac.api.dto.CacheRate;
import com.senac.api.dto.Company;
import com.senac.api.dto.IndividualRate;
import com.senac.api.dto.InlineResponse200;
import com.senac.api.mapper.FilterApiMapper;
import com.senac.api.mapper.Mapper;
import com.senac.domain.dto.Filter;
import com.senac.usecase.usecase.company.GetCompanyByScrollUseCase;
import com.senac.usecase.usecase.company.GetCompanyUseCase;
import com.senac.usecase.usecase.company.SaveCompanyUseCase;
import com.senac.usecase.usecase.company.UpdateCompanyUseCase;
import com.senac.usecase.usecase.rate.AddRateUseCase;
import com.senac.usecase.usecase.rate.GetCacheCodeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class CompanyRoute implements CompaniesApiDelegate {

    private final SaveCompanyUseCase saveCompanyUseCase;
    private final UpdateCompanyUseCase updateCompanyUseCase;
    private final GetCompanyUseCase getCompanyUseCase;
    private final GetCompanyByScrollUseCase getCompanyByScrollUseCase;
    private final GetCacheCodeUseCase getCacheCodeUseCase;
    private final AddRateUseCase addRateUseCase;

    @Override
    public ResponseEntity<Void> addCompany(Company body) {
       saveCompanyUseCase.execute(Mapper.toDomain(body));
       return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateCompany(Company body) {
        updateCompanyUseCase.execute(Mapper.toDomain(body));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<InlineResponse200> findCompanies(String serviceDescription, List<Object> priceCategory, List<String> serviceType, Double latitude, Double longitude, List<String> day, Integer rateInit, Integer rateFinal) {
        final Filter filter = FilterApiMapper.toDomain(serviceDescription,
                priceCategory,
                serviceType,
                latitude,
                longitude,
                day,
                rateInit,
                rateFinal);

        return ResponseEntity.ok().body(Mapper.toResponse(getCompanyUseCase.execute(filter)));
    }

    @Override
    public ResponseEntity<InlineResponse200> findCompaniesByScroll(String scroll) {
        return ResponseEntity.ok().body(Mapper.toResponse(getCompanyByScrollUseCase.execute(scroll)));
    }

    @Override
    public ResponseEntity<CacheRate> getRate(String companyId) {
        return ResponseEntity.ok().body(Mapper.toResponse(getCacheCodeUseCase.execute(companyId)));
    }

    @Override
    public ResponseEntity<Void> addRate(String companyId, String cacheCode, IndividualRate body) {
        addRateUseCase.execute(companyId, cacheCode, Mapper.toDomain(body));
        return ResponseEntity.ok().build();
    }
}
