package com.senac.infrastructure.query.impl;

import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.enums.PriceCategory;
import com.senac.infrastructure.query.CustomQuery;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.GeoDistanceOrder;
import org.springframework.data.elasticsearch.core.query.Query;


import java.util.Map;

public class QueryGetAllImpl implements CustomQuery {

    @Override
    public Query execute(Map<String, String> params) {
        Double lat = Double.valueOf(params.get(ParamsConstant.GEO_LAT));
        Double lon = Double.valueOf(params.get(ParamsConstant.GEO_LON));
        var teste = new GeoDistanceSortBuilder("location", lat, lon);

        GeoPoint location = new GeoPoint(lat, lon);
        Sort sort = Sort.by(new GeoDistanceOrder("location", location).withUnit("km"));

        return new CriteriaQuery(build(params)).addSort(sort);
    }

    private final Criteria build(Map<String, String> params) {
        String serviceDesc = params.get(ParamsConstant.SERVICE_DESC);
        PriceCategory priceCategory = null;

        if(params.get(ParamsConstant.PRICE_CATEGORY) != null) {
            priceCategory = PriceCategory.valueOf(params.get(ParamsConstant.PRICE_CATEGORY).toUpperCase());
        }

        Integer pageNumber = Integer.valueOf(params.get(ParamsConstant.PAGE_NUMBER));

        Double lat = Double.valueOf(params.get(ParamsConstant.GEO_LAT));
        Double lon = Double.valueOf(params.get(ParamsConstant.GEO_LON));

        return getPageNumber(pageNumber)
                .subCriteria(
                        getServicePrice(priceCategory)
                        .subCriteria(
                                getServiceDescription(serviceDesc).subCriteria(
                                        getGeoPoint(lon, lat)
                                )
                        )
                );
    }


    private Criteria getPageNumber(Integer pageNumber) {
        return new Criteria("pageNumber").is(pageNumber);
    }

    private Criteria getServicePrice(PriceCategory priceCategory) {
        return new Criteria("services.price")
                .between(priceCategory.min, priceCategory.max);
    }

    private Criteria getServiceDescription(String serviceDescription) {
        Criteria criteria = new Criteria("services.description").is(serviceDescription);
        if(serviceDescription == null) criteria = criteria.or("services.description").notEmpty();
        return criteria;
    }

    private Criteria getGeoPoint(Double lon, Double lat) {
        final GeoPoint geoPoint = new GeoPoint(lat, lon);
        return new Criteria("location").within(geoPoint, "1km");
    }
}
