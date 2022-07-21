package com.senac.adapter.gateway.cache;

import com.senac.domain.dto.Cache;

public interface CacheGateway {
    Cache generateCode(String companyId);
    String getCompanyId(String cacheCode);
}
