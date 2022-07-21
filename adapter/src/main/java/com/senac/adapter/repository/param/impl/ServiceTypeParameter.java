package com.senac.adapter.repository.param.impl;

import com.senac.adapter.repository.param.Parameter;
import com.senac.commons.constants.ParamsConstant;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ServiceTypeParameter implements Parameter<Criteria> {

    private static final String FIELD = "services.type";

    @Override
    public Criteria build(Map<String, Object> params) {
        final List<String> serviceType = (List<String>) params.get(ParamsConstant.SERVICE_TYPE);
        byte count = 0;
        Criteria criteria = null;
        for(String type : serviceType) {
            if (count == 0) {
                count++;
                criteria = new Criteria(FIELD).is(type);
            }
            else criteria = criteria.or(FIELD).is(type);
        }
        return criteria;
    }
}
