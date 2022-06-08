package com.senac.infrastructure.param.impl;

import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.param.Parameter;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.Map;

public class RateParameter implements Parameter<Criteria> {
    @Override
    public Criteria build(Map<String, String> params) {
        final Double avg = Double.valueOf(params.get(ParamsConstant.RATE));
        return new Criteria("rate.avg")
                .is(avg);
    }
}
