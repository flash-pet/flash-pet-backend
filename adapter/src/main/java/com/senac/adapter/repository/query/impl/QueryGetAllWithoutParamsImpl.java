package com.senac.adapter.repository.query.impl;

import com.senac.adapter.repository.query.CustomQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

import java.util.Map;

public class QueryGetAllWithoutParamsImpl implements CustomQuery {

    @Override
    public Query execute(Map<String, Object> params) {
        return new NativeSearchQueryBuilder().build();
    }
}
