package com.senac.usecase.usecase.rate;

import com.senac.adapter.exception.CacheException;
import com.senac.adapter.gateway.cache.CacheGateway;
import com.senac.adapter.repository.CompanyRepository;
import com.senac.domain.entity.Company;
import com.senac.domain.entity.IndividualRate;
import com.senac.usecase.exception.CompanyServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
public class AddRateUseCaseImpl implements AddRateUseCase {

    private final CompanyRepository companyRepository;
    private final CacheGateway cacheGateway;

    @Override
    public void execute(String companyId, String cache_code, IndividualRate individualRate) {
        final String cacheCompanyId = cacheGateway.getCompanyId(cache_code);

        if(cacheCompanyId == null) {
            throw new CacheException("Cache not exit");
        }

        if(!companyId.equals(cacheCompanyId)) {
            throw new CompanyServiceException("CompanyId is not valid");
        }

        final Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyServiceException("Company not exist"));

        company.getRate().getIndividualRates().add(individualRate);

        AtomicInteger value = new AtomicInteger(0);
        AtomicInteger qtd = new AtomicInteger(0);

        company.getRate().getIndividualRates().forEach(rate -> {
            value.set(value.get() + rate.getValue());
            qtd.set(qtd.get() + 1);
        });

        company.getRate().setAvg(Double.valueOf(value.get() / qtd.get()));

        companyRepository.save(company);
    }
}
