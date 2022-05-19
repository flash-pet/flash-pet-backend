package com.senac.service.mapper;

import com.senac.domain.input.PetShopInp;
import com.senac.domain.output.PetShopOut;
import com.senac.infrastructure.entity.PetShop;

public class PetShopServiceMapper {
    private PetShopServiceMapper(){}

    public static PetShopOut toOut(PetShop petShop) {
        return PetShopOut.builder()
                .id(petShop.getId())
                .name(petShop.getName())
                .build();
    }

    public static PetShop toEntity(PetShopInp petShopInp) {
        return PetShop.builder()
                .name(petShopInp.getName())
                .build();
    }
}
