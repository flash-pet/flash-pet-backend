package com.senac.infrastructure.query.impl;

import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.enums.PriceCategory;
import com.senac.infrastructure.query.CustomQuery;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;


import java.util.Map;

public class QueryGetAllImpl implements CustomQuery {

    @Override
    public Query execute(Map<String, String> params) {
        return new CriteriaQuery(build(params));
    }

    private final Criteria build(Map<String, String> params) {
        String serviceDesc = params.get(ParamsConstant.SERVICE_DESC);
        PriceCategory priceCategory = PriceCategory.LOW_MAX_100_1000;

        if(params.get(ParamsConstant.PRICE_CATEGORY) != null) {
            priceCategory = PriceCategory.valueOf(params.get(ParamsConstant.PRICE_CATEGORY).toUpperCase());
        }

        Integer pageNumber = Integer.valueOf(params.get(ParamsConstant.PAGE_NUMBER));

        return getPageNumber(pageNumber)
                .subCriteria(
                        getServicePrice(priceCategory)
                        .subCriteria(
                                getServiceDescription(serviceDesc)
                        )
                );
    }


    private Criteria getPageNumber(Integer pageNumber) {
        return new Criteria("pageNumber").is(pageNumber);
    }

    private Criteria getServicePrice(PriceCategory priceCategory) {
        return new Criteria("services.price")
                .between(priceCategory.min, priceCategory.max);
    }

    private Criteria getServiceDescription(String serviceDescription) {
        return new Criteria("services.description").is(serviceDescription)
                .or("services.description").notEmpty();
    }

}
