package com.senac.service.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RateCache {
    private RateCache() {}

    private static final Cache<String, String> RATE_CACHE = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(2, TimeUnit.MINUTES)
            .build();

    public static String generateCode(String companyId) {
        final String code = UUID.randomUUID().toString();
        RATE_CACHE.put(code, companyId);
        return code;
    }

    public static String getCompanyId(String cacheCode) {
        return RATE_CACHE.getIfPresent(cacheCode);
    }
}
