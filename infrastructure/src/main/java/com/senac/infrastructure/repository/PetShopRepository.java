package com.senac.infrastructure.repository;

import com.senac.infrastructure.entity.PetShop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetShopRepository extends CrudRepository<PetShop, UUID> {
}
