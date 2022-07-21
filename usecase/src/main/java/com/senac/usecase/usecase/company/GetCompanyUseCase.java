package com.senac.usecase.usecase.company;

import com.senac.domain.dto.Filter;
import com.senac.domain.entity.Company;
import org.springframework.data.elasticsearch.core.SearchScrollHits;


public interface GetCompanyUseCase {
    SearchScrollHits<Company> execute(Filter filter);
}
