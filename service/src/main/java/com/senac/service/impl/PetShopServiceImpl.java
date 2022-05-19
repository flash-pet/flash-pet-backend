package com.senac.service.impl;

import com.senac.domain.input.PetShopInp;
import com.senac.domain.output.PetShopOut;
import com.senac.infrastructure.entity.PetShop;
import com.senac.infrastructure.repository.PetShopRepository;
import com.senac.service.PetShopService;
import com.senac.service.exception.PetShopServiceException;
import com.senac.service.mapper.PetShopServiceMapper;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetShopServiceImpl implements PetShopService {

    private final PetShopRepository petShopRepository;

    @Override
    public PetShopOut getById(UUID id) {
        final PetShop petShop = petShopRepository.findById(id)
                .orElseThrow(() -> new PetShopServiceException("Pet Shop does not exist"));

        return PetShopServiceMapper.toOut(petShop);
    }

    @Override
    public PetShopOut save(PetShopInp petShopInp) {
        try {
            final PetShop petShopSaved = petShopRepository.save(PetShopServiceMapper.toEntity(petShopInp));
            return PetShopServiceMapper.toOut(petShopSaved);
        } catch (Exception e) {
            throw new PetShopServiceException("Error to save pet shop", e);
        }
    }

    @Override
    public List<PetShopOut> getAll() {
        return IteratorUtils.toList(petShopRepository.findAll().iterator())
                .stream().map(petShop -> PetShopServiceMapper.toOut(petShop))
                .collect(Collectors.toList());
    }
}
