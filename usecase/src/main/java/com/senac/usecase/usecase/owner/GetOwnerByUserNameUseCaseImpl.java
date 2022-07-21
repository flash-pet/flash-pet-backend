package com.senac.usecase.usecase.owner;

import com.senac.adapter.repository.CompanyRepository;
import com.senac.domain.entity.Owner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetOwnerByUserNameUseCaseImpl implements GetOwnerByUserNameUseCase {

    private final CompanyRepository companyRepository;

    @Override
    public Owner getByUsername(String username) {
        return companyRepository.findCompanyByOwnerUsername(username).getOwner();
    }
}
