package com.senac.usecase.usecase.rate;

import com.senac.domain.entity.IndividualRate;

public interface AddRateUseCase {
    void execute(String companyId, String cacheCode, IndividualRate individualRate);
}
