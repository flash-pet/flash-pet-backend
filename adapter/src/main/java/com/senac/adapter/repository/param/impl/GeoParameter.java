package com.senac.adapter.repository.param.impl;

import com.senac.adapter.repository.param.Parameter;
import com.senac.commons.constants.ParamsConstant;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.Map;

public class GeoParameter implements Parameter<Criteria> {
    @Override
    public Criteria build(Map<String, Object> params) {
        final Double lat = Double.valueOf((String) params.get(ParamsConstant.GEO_LAT));
        final Double lon = Double.valueOf((String) params.get(ParamsConstant.GEO_LON));
        final Double distance = Double.valueOf((String) params.get(ParamsConstant.DISTANCE));

        final GeoPoint geoPoint = new GeoPoint(lat, lon);
        return new Criteria("location").within(geoPoint, distance+"km");
    }
}
