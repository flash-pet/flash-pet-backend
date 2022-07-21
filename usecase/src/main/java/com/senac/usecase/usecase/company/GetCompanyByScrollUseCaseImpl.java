package com.senac.usecase.usecase.company;

import com.senac.domain.entity.Company;
import com.senac.usecase.config.UseCaseProperties;
import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchScrollHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GetCompanyByScrollUseCaseImpl implements  GetCompanyByScrollUseCase {

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;
    private final UseCaseProperties useCaseProperties;

    @Override
    public SearchScrollHits<Company> execute(String scrollId) {
        return elasticsearchRestTemplate.searchScrollContinue(scrollId, useCaseProperties.getScrollTime(),
                Company.class, IndexCoordinates.of("companyindex"));
    }
}
