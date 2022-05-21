package com.senac.infrastructure.query;

import com.senac.infrastructure.enums.QueryType;
import com.senac.infrastructure.query.impl.QueryGetAllImpl;

public class QueryFactory {
    public static CustomQuery getQuery(QueryType queryType) {
        switch (queryType) {
            case GET_ALL: return new QueryGetAllImpl();
            default: throw new RuntimeException("Class not implemented");
        }
    }
}
