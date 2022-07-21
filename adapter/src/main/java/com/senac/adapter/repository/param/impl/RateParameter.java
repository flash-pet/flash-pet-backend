package com.senac.adapter.repository.param.impl;

import com.senac.adapter.repository.param.Parameter;
import com.senac.commons.constants.ParamsConstant;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.Map;

public class RateParameter implements Parameter<Criteria> {
    @Override
    public Criteria build(Map<String, Object> params) {
         Double rateI = Double.valueOf((Integer) params.get(ParamsConstant.RATE));
         Double rateF = Double.valueOf((Integer) params.get(ParamsConstant.RATEF));
        if (rateI == null) rateI = 0.0;
        if (rateF == null) rateF = 5.0;

        return new Criteria("rate.avg")
                .between(rateI, rateF);
    }
}
