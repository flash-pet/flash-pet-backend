package com.senac.infrastructure.query.impl;

import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.enums.PriceCategory;
import com.senac.infrastructure.param.Parameter;
import com.senac.infrastructure.param.impl.GeoParameter;
import com.senac.infrastructure.param.impl.PriceCategoryParameter;
import com.senac.infrastructure.param.impl.ServiceDescriptionParameter;
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


import java.util.*;

public class QueryGetAllImpl implements CustomQuery {

    @Override
    public Query execute(Map<String, String> params) {
        Query query;
        if(params.get(ParamsConstant.GEO_LAT) != null && params.get(ParamsConstant.GEO_LON) != null) {
            Double lat = Double.valueOf(params.get(ParamsConstant.GEO_LAT));
            Double lon = Double.valueOf(params.get(ParamsConstant.GEO_LON));
            var teste = new GeoDistanceSortBuilder("location", lat, lon);

            GeoPoint location = new GeoPoint(lat, lon);
            Sort sort = Sort.by(new GeoDistanceOrder("location", location).withUnit("km"));
            query = new CriteriaQuery(build(params)).addSort(sort);
        } else {
            query = new CriteriaQuery(build(params));
        }

        return query;
    }

    private final Criteria build(Map<String, String> params) {
        final Queue<Criteria> parameters = new LinkedList<Criteria>();

        if(params.get(ParamsConstant.SERVICE_DESC) != null)
            parameters.add(new ServiceDescriptionParameter().build(params));

        if(params.get(ParamsConstant.PRICE_CATEGORY) != null)
            parameters.add(new PriceCategoryParameter().build(params));

        if(params.get(params.get(ParamsConstant.GEO_LAT)) != null &&
                params.get(params.get(ParamsConstant.GEO_LON)) != null)
            parameters.add(new GeoParameter().build(params));

        Criteria criteria = parameters.poll();
        while (parameters.size() > 0 ) {
            criteria = criteria.subCriteria(parameters.poll());
        }

        return criteria;
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
