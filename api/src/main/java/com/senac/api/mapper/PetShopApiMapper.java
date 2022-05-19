package com.senac.api.mapper;

import com.senac.api.dto.Pet;
import com.senac.domain.input.PetShopInp;
import com.senac.domain.output.PetShopOut;

public class PetShopApiMapper {
    public static Pet toResponse(PetShopOut petShopOut) {
        final Pet pet = new Pet();
        pet.name(petShopOut.getName());
        return pet;
    }

    public static PetShopInp toIn(Pet pet) {
        return PetShopInp.builder()
                .name(pet.getName())
                .build();
    }
}
