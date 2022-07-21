package com.senac.usecase.usecase.company;

import com.senac.domain.entity.Company;
import org.springframework.data.elasticsearch.core.SearchScrollHits;

public interface GetCompanyByOwnerUserNameUseCase {
    SearchScrollHits<Company> execute(String username);
}
