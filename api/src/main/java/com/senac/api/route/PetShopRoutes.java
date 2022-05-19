package com.senac.api.route;

import com.senac.api.dto.Pet;
import com.senac.api.mapper.PetShopApiMapper;
import com.senac.service.PetShopService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@AllArgsConstructor
public class PetShopRoutes implements PetApiDelegate {

    private PetShopService service;

    @Override
    public ResponseEntity<Pet> getPetById(UUID petId) {
        return ResponseEntity.ok(PetShopApiMapper.toResponse(service.getById(petId)));
    }

    @Override
    public ResponseEntity<Void> addPet(Pet body) {
        service.save(PetShopApiMapper.toIn(body));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
