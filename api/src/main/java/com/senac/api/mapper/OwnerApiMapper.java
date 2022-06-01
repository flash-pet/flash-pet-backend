package com.senac.api.mapper;

import com.senac.api.dto.Owner;
import com.senac.domain.input.OwnerInp;
import com.senac.domain.output.OwnerOut;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class OwnerApiMapper {
    private OwnerApiMapper(){}

    public static final OwnerInp toDomain(Owner owner) {
        return OwnerInp.builder()
                .email(owner.getEmail())
                .password(owner.getPassword())
                .username(owner.getUsername())
                .password(new BCryptPasswordEncoder().encode(owner.getPassword()))
                .build();
    }

    public static final Owner toResponse(OwnerOut owner) {
        final Owner ownerResponse = new Owner();
        ownerResponse.setUsername(owner.getUsername());
        ownerResponse.setPassword(owner.getPassword());
        ownerResponse.setEmail(owner.getEmail());
        ownerResponse.setId(owner.getId());
        return ownerResponse;
    }
}
