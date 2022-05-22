package com.senac.infrastructure.query;

import com.senac.infrastructure.enums.QueryType;
import com.senac.infrastructure.query.impl.QueryGetAllImpl;
import com.senac.infrastructure.query.impl.QueryGetAllWithoutParamsImpl;

public class QueryFactory {
    public static CustomQuery getQuery(QueryType queryType) {
        switch (queryType) {
            case GET_ALL: return new QueryGetAllImpl();
            case GET_ALL_WITHOUT_PARAMS: return new QueryGetAllWithoutParamsImpl();
            default: throw new RuntimeException("Class not implemented");
        }
    }
}
