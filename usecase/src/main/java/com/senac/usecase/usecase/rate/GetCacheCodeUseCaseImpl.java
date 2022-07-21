package com.senac.usecase.usecase.rate;

import com.senac.adapter.gateway.cache.CacheGateway;
import com.senac.adapter.repository.CompanyRepository;
import com.senac.domain.dto.Cache;
import com.senac.usecase.exception.CompanyServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetCacheCodeUseCaseImpl implements GetCacheCodeUseCase {

    private final CompanyRepository companyRepository;
    private final CacheGateway cacheGateway;

    @Override
    public Cache execute(String companyId) {
        companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyServiceException("Company not exist"));

        return cacheGateway.generateCode(companyId);
    }
}
