package com.senac.service.mapper;

import com.senac.domain.input.OwnerInp;
import com.senac.domain.output.OwnerOut;
import com.senac.infrastructure.entity.Owner;

import java.util.UUID;

public class OwnerMapper {
    private OwnerMapper(){}

    public static final OwnerOut toOut(Owner owner) {
        if(owner == null) return null;
        return OwnerOut.builder()
                .username(owner.getUsername())
                .email(owner.getEmail())
                .id(owner.getId())
                .password(owner.getPassword())
                .cnpj(owner.getCnpj())
                .build();
    }

    public static final Owner toEntity(OwnerInp ownerInp) {
        if(ownerInp == null) return null;
        return Owner.builder()
                .id(ownerInp.getId() == null ? UUID.randomUUID().toString() : ownerInp.getId())
                .password(ownerInp.getPassword())
                .username(ownerInp.getUsername())
                .password(ownerInp.getPassword())
                .cnpj(ownerInp.getCnpj())
                .email(ownerInp.getEmail()).build();
    }
}
