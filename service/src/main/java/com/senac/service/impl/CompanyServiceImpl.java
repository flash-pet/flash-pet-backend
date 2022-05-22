package com.senac.service.impl;

import com.senac.domain.input.CompanyInp;
import com.senac.domain.input.Filter;
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
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public CompanyOut add(CompanyInp companyInp) {
        try {
            final Company company = CompanyMapper.toEntity(companyInp);

            int size = IteratorUtils.toList(companyRepository.findAll().iterator()).size();
            var pageNumber = size / 5;

            company.setPageNumber(pageNumber);

            company.setLocation(new GeoPoint(companyInp.getLat(), companyInp.getLon()));

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
    public List<CompanyOut> getAll(final Filter filter) {
        final Map<String, String> params = Map.of(
                ParamsConstant.PAGE_NUMBER, filter.getPageNumber().toString(),
                ParamsConstant.SERVICE_DESC, filter.getServiceDescription(),
                ParamsConstant.PRICE_CATEGORY, filter.getPriceCategory(),
                ParamsConstant.GEO_LAT, filter.getLat().toString(),
                ParamsConstant.GEO_LON, filter.getLon().toString()
        );

        final CustomQuery customQuery = QueryFactory.getQuery(QueryType.GET_ALL);
        final Query query = customQuery.execute(params);

        final SearchHits<Company> companySearchHits = elasticsearchRestTemplate.search(query, Company.class);

        return IteratorUtils.toList(companySearchHits.iterator()).stream().map(it -> CompanyMapper.toOut(it.getContent())).collect(Collectors.toList());
    }

}
