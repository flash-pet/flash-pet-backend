package com.senac.infrastructure.param.impl;

import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.param.Parameter;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.Map;

public class ServiceDescriptionParameter implements Parameter<Criteria> {
    @Override
    public Criteria build(Map<String, String> params) {
        final String serviceDesc = params.get(ParamsConstant.SERVICE_DESC);
        return new Criteria("services.description").is(serviceDesc);
    }
}
