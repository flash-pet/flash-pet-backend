package com.senac.adapter.repository.query;

import com.senac.adapter.repository.query.impl.QueryGetAllImpl;
import com.senac.adapter.repository.query.impl.QueryGetAllWithoutParamsImpl;
import com.senac.commons.enums.QueryType;

public class QueryFactory {
    public static CustomQuery getQuery(QueryType queryType) {
        switch (queryType) {
            case GET_ALL: return new QueryGetAllImpl();
            case GET_ALL_WITHOUT_PARAMS: return new QueryGetAllWithoutParamsImpl();
            default: throw new RuntimeException("Class not implemented");
        }
    }
}
