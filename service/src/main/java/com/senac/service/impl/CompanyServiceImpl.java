package com.senac.service.impl;

import com.senac.domain.input.CompanyInp;
import com.senac.domain.input.Filter;
import com.senac.domain.output.CompanyGetAllOut;
import com.senac.domain.output.CompanyOut;
import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.entity.Company;
import com.senac.infrastructure.enums.QueryType;
import com.senac.infrastructure.query.CustomQuery;
import com.senac.infrastructure.query.QueryFactory;
import com.senac.infrastructure.repository.CompanyRepository;
import com.senac.service.CompanyService;
import com.senac.service.exception.CompanyServiceException;
import com.senac.service.mapper.CompanyMapper;
import com.senac.service.utils.FilterUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchScrollHits;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ElasticsearchRestTemplate elasticsearchRestTemplate;
    private static final long SCROLL_TIME = (long) (1000 * 60) * 60;

    @Override
    public CompanyOut add(CompanyInp companyInp) {
        try {
            final Company company = CompanyMapper.toEntity(companyInp);

            return CompanyMapper.toOut(companyRepository.save(company));
        } catch (Exception e) {
            throw new CompanyServiceException("Error to save company", e);
        }
    }

    @Override
    public CompanyOut update(CompanyInp companyInp) {
        try {
            return CompanyMapper.toOut(companyRepository.save(CompanyMapper.toEntity(companyInp)));
        } catch (Exception e) {
            throw new CompanyServiceException("Error to save company", e);
        }
    }

    @Override
    public CompanyGetAllOut getAll(final Filter filter) {
        Query query;

        if(FilterUtils.isEmpty(filter)) {
            query = QueryFactory.getQuery(QueryType.GET_ALL_WITHOUT_PARAMS).execute(null);
        } else {
            final Map<String, String> params = new HashMap<String, String>() {{
                put(ParamsConstant.SERVICE_DESC, filter.getServiceDescription());
                put(ParamsConstant.SERVICE_TYPE, filter.getServiceType());
                put(ParamsConstant.PRICE_CATEGORY, filter.getPriceCategory());
                put(ParamsConstant.GEO_LAT, filter.getLat() == null ? null : filter.getLat().toString());
                put(ParamsConstant.GEO_LON, filter.getLon() == null ? null : filter.getLon().toString());
            }};

            query = QueryFactory.getQuery(QueryType.GET_ALL).execute(params);
        }

        final SearchScrollHits<Company> companySearchScrollHits = elasticsearchRestTemplate.searchScrollStart(SCROLL_TIME, query, Company.class, IndexCoordinates.of("companyindex"));

        final List<CompanyOut> companyOutList = IteratorUtils.toList(companySearchScrollHits.iterator())
                .stream()
                .map(it -> CompanyMapper.toOut(it.getContent()))
                .collect(Collectors.toList());

        return CompanyGetAllOut.builder()
                .scrollId(companySearchScrollHits.getScrollId())
                .companies(companyOutList).build();
    }

    @Override
    public CompanyGetAllOut getByScroll(String scroll) {

        final SearchScrollHits<Company> companySearchScrollHits = elasticsearchRestTemplate.searchScrollContinue(scroll, SCROLL_TIME, Company.class, IndexCoordinates.of("companyindex"));

        final List<CompanyOut> companyOutList = IteratorUtils.toList(companySearchScrollHits.iterator())
                .stream()
                .map(it -> CompanyMapper.toOut(it.getContent()))
                .collect(Collectors.toList());

        return CompanyGetAllOut.builder()
                .scrollId(companySearchScrollHits.getScrollId())
                .companies(companyOutList).build();
    }

}
