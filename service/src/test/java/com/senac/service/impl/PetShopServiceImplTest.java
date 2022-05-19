package com.senac.service.impl;

import com.senac.infrastructure.entity.PetShop;
import com.senac.infrastructure.repository.PetShopRepository;
import com.senac.service.PetShopService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PetShopServiceImplTest {

    private PetShopService petShopService;

    private PetShopRepository petShopRepository;

    @BeforeEach
    public void setup() {
        petShopRepository = Mockito.mock(PetShopRepository.class);
        petShopService = new PetShopServiceImpl(petShopRepository);
    }

    @Test
    void getById() {
        Mockito.when(petShopRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new PetShop()));

        var result = petShopService.getById(UUID.randomUUID());
        Assertions.assertNotNull(result);
    }

    @Test
    void save() {
    }

    @Test
    void getAll() {
    }
}