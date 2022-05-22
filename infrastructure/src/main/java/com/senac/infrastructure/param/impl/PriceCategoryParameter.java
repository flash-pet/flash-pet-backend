package com.senac.infrastructure.param.impl;

import com.senac.infrastructure.constants.ParamsConstant;
import com.senac.infrastructure.enums.PriceCategory;
import com.senac.infrastructure.param.Parameter;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.Map;

public class PriceCategoryParameter implements Parameter<Criteria> {
    @Override
    public Criteria build(Map<String, String> params) {
        final PriceCategory priceCategory = PriceCategory.valueOf(params.get(ParamsConstant.PRICE_CATEGORY).toUpperCase());
        return new Criteria("services.price")
                .between(priceCategory.min, priceCategory.max);
    }
}
