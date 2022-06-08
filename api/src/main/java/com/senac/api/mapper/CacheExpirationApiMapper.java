package com.senac.api.mapper;

import com.senac.api.dto.CacheRate;
import com.senac.domain.output.CacheExpirationOut;

public class CacheExpirationApiMapper {
    private CacheExpirationApiMapper(){}

    public static final CacheRate toResponse(CacheExpirationOut cacheExpirationOut) {
        final CacheRate cacheRate = new CacheRate();
        cacheRate.setCode(cacheExpirationOut.getValue());
        cacheRate.setExpiration(cacheExpirationOut.getExpiration());
        return cacheRate;
    }
}
