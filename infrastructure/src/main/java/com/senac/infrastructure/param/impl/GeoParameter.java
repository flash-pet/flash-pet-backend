package com.senac.infrastructure.param.impl;

import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.param.Parameter;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.Map;

public class GeoParameter implements Parameter<Criteria> {
    @Override
    public Criteria build(Map<String, String> params) {
        final Double lat = Double.valueOf(params.get(ParamsConstant.GEO_LAT));
        final Double lon = Double.valueOf(params.get(ParamsConstant.GEO_LON));
        final Double distance = Double.valueOf(params.get(ParamsConstant.DISTANCE));

        final GeoPoint geoPoint = new GeoPoint(lat, lon);
        return new Criteria("location").within(geoPoint, distance+"km");
    }
}
