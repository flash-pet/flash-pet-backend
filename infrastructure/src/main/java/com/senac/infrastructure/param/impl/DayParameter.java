package com.senac.infrastructure.param.impl;

import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.enums.DayType;
import com.senac.infrastructure.param.Parameter;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.Map;

public class DayParameter implements Parameter<Criteria> {

    @Override
    public Criteria build(Map<String, String> params) {
        final DayType dayType = DayType.valueOf(params.get(ParamsConstant.DAY).toUpperCase());
        return new Criteria("days.type").is(dayType);
    }
}
