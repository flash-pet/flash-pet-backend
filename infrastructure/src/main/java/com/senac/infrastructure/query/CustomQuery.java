package com.senac.infrastructure.query;

import org.springframework.data.elasticsearch.core.query.Query;

import java.util.Map;

public interface CustomQuery {
    Query execute(Map<String, String> params);
}
