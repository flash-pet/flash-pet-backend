package com.senac.usecase.utils;

import com.senac.domain.dto.Filter;

public class FilterUtils {
    private FilterUtils(){}

    public static final boolean isEmpty(final Filter filter) {
        return filter.getServiceDescription()   == null   &&
                filter.getServiceType()         == null   &&
                filter.getPriceCategory()       == null   &&
                filter.getLon()                 == null   &&
                filter.getLat()                 == null   &&
                filter.getDay()                 == null   &&
                filter.getRate()                == null;
    }
}
