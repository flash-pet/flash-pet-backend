package com.senac.adapter.repository.param.impl;

import com.senac.adapter.repository.param.Parameter;
import com.senac.commons.constants.ParamsConstant;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.Map;

public class ServiceDescriptionParameter implements Parameter<Criteria> {
    @Override
    public Criteria build(Map<String, Object> params) {
        final String serviceDesc = (String) params.get(ParamsConstant.SERVICE_DESC);
        return new Criteria("services.description").is(serviceDesc);
    }
}
