package com.senac.usecase.usecase.rate;

import com.senac.domain.dto.Cache;

public interface GetCacheCodeUseCase {
    Cache execute(String companyId);
}
