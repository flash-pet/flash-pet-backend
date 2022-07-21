package com.senac.api.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senac.api.dto.CacheRate;
import com.senac.api.dto.IndividualRate;
import com.senac.api.dto.InlineResponse200;
import com.senac.api.dto.InlineResponse2001;
import com.senac.api.exception.ParseException;
import com.senac.domain.dto.Cache;
import com.senac.domain.entity.Company;
import com.senac.domain.entity.Rate;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.data.elasticsearch.core.SearchScrollHits;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.stream.Collectors;

public class Mapper {
    private Mapper(){}
    private static final ObjectMapper MAPPER;

    static {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER = mapper;
    }

    public static com.senac.domain.entity.Company toDomain(com.senac.api.dto.Company company) {
        try {
            String json = MAPPER.writeValueAsString(company);
            var response = MAPPER.readValue(json, com.senac.domain.entity.Company.class);
            response.setLocation(new GeoPoint(company.getLatitude(), company.getLongitude()));
            response.setDays(DayApiMapper.toDomain(company.getDays()));
            return response;
        } catch (Exception e){
            throw new ParseException("Error to parse company request to domain", e);
        }
    }

    public static com.senac.domain.entity.IndividualRate toDomain(com.senac.api.dto.IndividualRate rate) {
       return com.senac.domain.entity.IndividualRate.builder()
               .description(rate.getDescription())
               .date(rate.getDate())
               .value(rate.getValue())
               .build();
    }

    public static com.senac.api.dto.Company toResponse(com.senac.domain.entity.Company company) {
        try {
            String json = MAPPER.writeValueAsString(company);
            var response = MAPPER.readValue(json, com.senac.api.dto.Company.class);
            response.setLatitude(company.getLocation().getLat());
            response.setLongitude(company.getLocation().getLon());
            response.setDays(DayApiMapper.toResponse(company.getDays()));
            return response;
        } catch (Exception e){
            throw new ParseException("Error to parse company to response", e);
        }
    }

    public static com.senac.api.dto.GetCompany toGetResponse(com.senac.domain.entity.Company company) {
        try {
            String json = MAPPER.writeValueAsString(company);
            var response = MAPPER.readValue(json, com.senac.api.dto.GetCompany.class);
            response.setLatitude(company.getLocation().getLat());
            response.setLongitude(company.getLocation().getLon());
            response.setDays(DayApiMapper.toResponse(company.getDays()));
            return response;
        } catch (Exception e){
            throw new ParseException("Error to parse company to response", e);
        }
    }

    public static InlineResponse200 toResponse(SearchScrollHits<Company> company) {
        try {
            final InlineResponse200 response200 = new InlineResponse200();
            response200.setScrollId(company.getScrollId());
            response200.setResultMatchs(String.valueOf(company.getTotalHits()));
            response200.setCompanies(company.get().map(companySearchHit -> toGetResponse(companySearchHit.getContent()))
                    .collect(Collectors.toList()));

            return response200;
        } catch (Exception e){
            throw new ParseException("Error to parse company to response", e);
        }
    }

    public static InlineResponse2001 toResponseOwner(SearchScrollHits<Company> company) {
        try {
            final InlineResponse2001 response2001 = new InlineResponse2001();
            response2001.setScrollId(company.getScrollId());
            response2001.setResultMatchs(String.valueOf(company.getTotalHits()));
            response2001.setCompanies(company.get().map(companySearchHit -> toResponse(companySearchHit.getContent()))
                    .collect(Collectors.toList()));

            return response2001;
        } catch (Exception e){
            throw new ParseException("Error to parse company to response", e);
        }
    }

    public static CacheRate toResponse(Cache cache) {
        final CacheRate cacheRate = new CacheRate();
        cacheRate.setExpiration(cache.getDuration());
        cacheRate.setCode(cache.getCode());
        return cacheRate;
    }
}
