package com.senac.adapter.repository.param.impl;

import com.senac.adapter.repository.param.Parameter;
import com.senac.commons.constants.ParamsConstant;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.List;
import java.util.Map;

public class DayParameter implements Parameter<Criteria> {
    private static final String FIELD = "days.type";

    @Override
    public Criteria build(Map<String, Object> params) {
        List<String> days = (List<String>) params.get(ParamsConstant.DAY);
        byte count = 0;
        Criteria criteria = null;
        for (String day: days) {
            if (count == 0) {
                count++;
                criteria = new Criteria(FIELD).is(day);
            } else criteria = criteria.or(FIELD).is(day);
        }
        return criteria;
    }
}
