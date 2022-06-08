package com.senac.infrastructure.query.impl;

import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.param.impl.*;
import com.senac.infrastructure.query.CustomQuery;
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

        if(params.get(ParamsConstant.DAY) != null)
            parameters.add(new DayParameter().build(params));

        if(params.get(ParamsConstant.RATE) != null)
            parameters.add(new RateParameter().build(params));

        Criteria criteria = parameters.poll();
        while (parameters.size() > 0 ) {
            criteria = criteria.subCriteria(parameters.poll());
        }

        return criteria;
    }
}
