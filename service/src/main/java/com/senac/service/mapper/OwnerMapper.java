package com.senac.service.mapper;

import com.senac.domain.input.OwnerInp;
import com.senac.domain.output.OwnerOut;
import com.senac.infrastructure.entity.Owner;

import java.util.UUID;

public class OwnerMapper {
    private OwnerMapper(){}

    public static final OwnerOut toOut(Owner owner) {
        return OwnerOut.builder()
                .username(owner.getUsername())
                .password(owner.getPassword())
                .email(owner.getEmail())
                .id(owner.getId())
                .build();
    }

    public static final Owner toEntity(OwnerInp ownerInp) {
        return Owner.builder()
                .id(UUID.randomUUID().toString())
                .password(ownerInp.getPassword())
                .username(ownerInp.getUsername())
                .password(ownerInp.getPassword())
                .email(ownerInp.getEmail()).build();
    }
}
