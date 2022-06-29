package com.senac.service.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.senac.service.config.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RateCache {

    private Cache<String, String> cache;

    public RateCache(@Autowired ServiceProperties serviceProperties) {
        cache = CacheBuilder.newBuilder()
                .maximumSize(serviceProperties.getCacheSize())
                .expireAfterWrite(serviceProperties.getCacheDuration(), TimeUnit.MINUTES)
                .build();
    }


    public String generateCode(String companyId) {
        final String code = UUID.randomUUID().toString();
        cache.put(code, companyId);
        return code;
    }

    public String getCompanyId(String cacheCode) {
        return cache.getIfPresent(cacheCode);
    }
}
