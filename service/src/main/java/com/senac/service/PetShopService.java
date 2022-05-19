package com.senac.service;

import com.senac.domain.input.PetShopInp;
import com.senac.domain.output.PetShopOut;
import com.senac.infrastructure.entity.PetShop;

import java.util.List;
import java.util.UUID;

public interface PetShopService {
    PetShopOut getById(UUID id);
    PetShopOut save(PetShopInp petShopInp);
    List<PetShopOut> getAll();
}
