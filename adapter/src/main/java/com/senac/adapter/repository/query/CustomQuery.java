package com.senac.adapter.repository.query;

import org.springframework.data.elasticsearch.core.query.Query;

import java.util.Map;

public interface CustomQuery {
    Query execute(Map<String, Object> params);
}
