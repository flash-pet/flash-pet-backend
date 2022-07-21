package com.senac.adapter.repository.param.impl;

import com.senac.adapter.repository.param.Parameter;
import com.senac.commons.constants.ParamsConstant;
import com.senac.commons.enums.PriceCategory;
import org.springframework.data.elasticsearch.core.query.Criteria;

import java.util.List;
import java.util.Map;

public class PriceCategoryParameter implements Parameter<Criteria> {
    private static final String FIELD = "services.price";

    @Override
    public Criteria build(Map<String, Object> params) {
        final List<String> prices = (List<String>) params.get(ParamsConstant.PRICE_CATEGORY);
        byte count = 0;
        Criteria criteria = null;
        for(String price : prices) {
            final PriceCategory priceCategory = PriceCategory.valueOf(price.toUpperCase());
            if (count == 0) {
                count++;
                criteria = new Criteria(FIELD)
                        .between(priceCategory.min, priceCategory.max);
            }
            else criteria = criteria.or(FIELD).between(priceCategory.min, priceCategory.max);
        }

        return criteria;
    }
}
