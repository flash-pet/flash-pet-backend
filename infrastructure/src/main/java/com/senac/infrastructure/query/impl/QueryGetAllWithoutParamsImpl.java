package com.senac.infrastructure.query.impl;

import com.senac.infrastructure.query.CustomQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

import java.util.Map;

public class QueryGetAllWithoutParamsImpl implements CustomQuery {

    @Override
    public Query execute(Map<String, String> params) {
        return new NativeSearchQueryBuilder().build();
    }
}
