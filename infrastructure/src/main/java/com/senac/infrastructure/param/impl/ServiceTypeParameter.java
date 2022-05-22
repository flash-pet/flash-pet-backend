package com.senac.infrastructure.param.impl;

import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.enums.PriceCategory;
import com.senac.infrastructure.enums.ServiceType;
import com.senac.infrastructure.param.Parameter;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.Map;

public class ServiceTypeParameter implements Parameter<Criteria> {
    @Override
    public Criteria build(Map<String, String> params) {
        final ServiceType serviceType = ServiceType.valueOf(params.get(ParamsConstant.SERVICE_TYPE).toUpperCase());
        return new Criteria("services.type").is(serviceType);
    }
}
