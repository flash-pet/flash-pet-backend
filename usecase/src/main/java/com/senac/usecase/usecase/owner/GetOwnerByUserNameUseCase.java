package com.senac.usecase.usecase.owner;

import com.senac.domain.entity.Owner;

public interface GetOwnerByUserNameUseCase {
    Owner getByUsername(String username);
}
