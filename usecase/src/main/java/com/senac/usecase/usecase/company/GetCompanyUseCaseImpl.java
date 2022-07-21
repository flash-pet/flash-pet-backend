package com.senac.usecase.usecase.company;

import com.senac.adapter.repository.query.QueryFactory;
import com.senac.commons.constants.ParamsConstant;
import com.senac.commons.enums.QueryType;
import com.senac.domain.dto.Filter;
import com.senac.domain.entity.Company;
import com.senac.usecase.config.UseCaseProperties;
import com.senac.usecase.utils.FilterUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchScrollHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class GetCompanyUseCaseImpl implements GetCompanyUseCase {

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;
    private final UseCaseProperties useCaseProperties;

    @Override
    public SearchScrollHits<Company> execute(Filter filter) {
        Query query;

        if(FilterUtils.isEmpty(filter)) {
            query = QueryFactory.getQuery(QueryType.GET_ALL_WITHOUT_PARAMS).execute(null);
        } else {
            final Map<String, Object> params = new HashMap() {{
                put(ParamsConstant.SERVICE_DESC, filter.getServiceDescription());
                put(ParamsConstant.SERVICE_TYPE, filter.getServiceType());
                put(ParamsConstant.PRICE_CATEGORY, filter.getPriceCategory());
                put(ParamsConstant.GEO_LAT, filter.getLat() == null ? null : filter.getLat().toString());
                put(ParamsConstant.GEO_LON, filter.getLon() == null ? null : filter.getLon().toString());
                put(ParamsConstant.DAY, filter.getDay());
                put(ParamsConstant.RATE, filter.getRate()   == null ? null : filter.getRate().toString());
                put(ParamsConstant.RATEF, filter.getRateFinal() == null ? null: filter.getRateFinal().toString());
            }};

            query = QueryFactory.getQuery(QueryType.GET_ALL).execute(params);

            query = query.setPageable(PageRequest.of(0, 10));
        }

        return elasticsearchRestTemplate.searchScrollStart(useCaseProperties.getScrollTime(),
                query, Company.class, IndexCoordinates.of("company_index"));
    }
}
