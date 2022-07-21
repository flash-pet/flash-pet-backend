package com.senac.usecase.usecase.company;

import com.senac.adapter.repository.CompanyRepository;
import com.senac.domain.entity.Company;
import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.core.SearchScrollHits;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetCompanyByOwnerUserNameUseCaseImpl implements GetCompanyByOwnerUserNameUseCase {

    private final CompanyRepository companyRepository;

    @Override
    public SearchScrollHits<Company> execute(String username) {
        return companyRepository.findCompaniesByOwnerUsername(username);
    }
}
