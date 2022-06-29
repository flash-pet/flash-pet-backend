package com.senac.api.mapper;

import com.senac.api.dto.Owner;
import com.senac.domain.input.OwnerInp;
import com.senac.domain.output.OwnerOut;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class OwnerApiMapper {
    private OwnerApiMapper(){}

    public static final OwnerInp toDomain(Owner owner) {
        if(owner == null) return null;
        return OwnerInp.builder()
                .email(owner.getEmail())
                .password(owner.getPassword())
                .username(owner.getUsername())
                .password(new BCryptPasswordEncoder().encode(owner.getPassword()))
                .cnpj(owner.getCnpj())
                .build();
    }

    public static final Owner toResponse(OwnerOut owner) {
        if(owner == null) return null;
        final Owner ownerResponse = new Owner();
        ownerResponse.setUsername(owner.getUsername());
        ownerResponse.setEmail(owner.getEmail());
        ownerResponse.setId(owner.getId());
        ownerResponse.setCnpj(owner.getCnpj());
        return ownerResponse;
    }
}
