package com.senac.service.impl;

import com.senac.domain.output.OwnerOut;
import com.senac.infrastructure.repository.CompanyRepository;
import com.senac.service.OwnerService;
import com.senac.service.mapper.OwnerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final CompanyRepository companyRepository;

    @Override
    public OwnerOut getByUsername(String username) {
        return OwnerMapper.toOut(companyRepository.findCompanyByOwnerUsername(username).getOwner());
    }
}
