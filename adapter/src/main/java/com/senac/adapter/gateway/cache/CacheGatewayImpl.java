package com.senac.adapter.gateway.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.senac.adapter.config.AdapterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class CacheGatewayImpl implements CacheGateway {

    private Cache<String, String> cache;
    private AdapterProperties adapterProperties;

    public CacheGatewayImpl(@Autowired AdapterProperties adapterProperties) {
        cache = CacheBuilder.newBuilder()
                .maximumSize(adapterProperties.getCacheSize())
                .expireAfterWrite(adapterProperties.getCacheDuration(), TimeUnit.MINUTES)
                .build();
        this.adapterProperties = adapterProperties;
    }

    public com.senac.domain.dto.Cache generateCode(String companyId) {
        final String code = UUID.randomUUID().toString();
        cache.put(code, companyId);
        return com.senac.domain.dto.Cache.builder()
                .code(code)
                .duration(adapterProperties.getCacheDuration().toString().concat("M"))
                .build();
    }

    public String getCompanyId(String cacheCode) {
        return cache.getIfPresent(cacheCode);
    }
}
