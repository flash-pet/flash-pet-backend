package com.senac.adapter.repository.query.impl;

import com.senac.adapter.repository.param.impl.*;
import com.senac.adapter.repository.query.CustomQuery;
import com.senac.commons.constants.ParamsConstant;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.GeoDistanceOrder;
import org.springframework.data.elasticsearch.core.query.Query;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QueryGetAllImpl implements CustomQuery {

    @Override
    public Query execute(Map<String, Object> params) {
        Query query;
        if(params.get(ParamsConstant.GEO_LAT) != null && params.get(ParamsConstant.GEO_LON) != null) {
            Double lat = Double.valueOf((String) params.get(ParamsConstant.GEO_LAT));
            Double lon = Double.valueOf((String) params.get(ParamsConstant.GEO_LON));

            GeoPoint location = new GeoPoint(lat, lon);
            Sort sort = Sort.by(new GeoDistanceOrder("location", location).withUnit("km"));
            query = new CriteriaQuery(build(params)).addSort(sort);
        } else {
            query = new CriteriaQuery(build(params));
        }

        return query;
    }

    private final Criteria build(Map<String, Object> params) {
        final Queue<Criteria> parameters = new LinkedList<Criteria>();

        if(params.get(ParamsConstant.SERVICE_DESC) != null)
            parameters.add(new ServiceDescriptionParameter().build(params));

        if (params.get(ParamsConstant.SERVICE_TYPE) != null)
            parameters.add(new ServiceTypeParameter().build(params));

        if(params.get(ParamsConstant.PRICE_CATEGORY) != null)
            parameters.add(new PriceCategoryParameter().build(params));

        if(params.get(params.get(ParamsConstant.GEO_LAT)) != null &&
                params.get(params.get(ParamsConstant.GEO_LON)) != null)
            parameters.add(new GeoParameter().build(params));

        if(params.get(ParamsConstant.DAY) != null)
            parameters.add(new DayParameter().build(params));

        if(params.get(ParamsConstant.RATE) != null || params.get(ParamsConstant.RATEF) != null)
            parameters.add(new RateParameter().build(params));

        Criteria criteria = parameters.poll();
        while (parameters.size() > 0 ) {
            criteria = criteria.subCriteria(parameters.poll());
        }

        return criteria;
    }
}
