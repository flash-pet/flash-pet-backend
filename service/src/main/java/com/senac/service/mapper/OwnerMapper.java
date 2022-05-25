package com.senac.service.mapper;

import com.senac.domain.output.OwnerOut;
import com.senac.infrastructure.entity.Owner;

public class OwnerMapper {
    private OwnerMapper(){}

    public static final OwnerOut toOut(Owner owner) {
        return OwnerOut.builder()
                .userName(owner.getUsername())
                .password(owner.getPassword())
                .build();
    }
}
