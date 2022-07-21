package com.senac.usecase.usecase.company;

import com.senac.adapter.gateway.cripto.CryptPasswordGateway;
import com.senac.adapter.gateway.s3.interactor.S3Interact;
import com.senac.adapter.repository.CompanyRepository;
import com.senac.commons.enums.S3Path;
import com.senac.domain.entity.Company;
import com.senac.domain.entity.Rate;
import com.senac.usecase.exception.CompanyServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SaveCompanyUseCaseImpl implements SaveCompanyUseCase {

    private final CompanyRepository companyRepository;
    private final S3Interact s3Interact;
    private final CryptPasswordGateway cryptPasswordGateway;

    @Override
    public void execute(Company company) {
        try {
            company.setLogo(s3Interact.saveImage(company.getLogo(), S3Path.LOGO));

            company.setCarrosel(company.getCarrosel().stream()
                    .map(image -> s3Interact.saveImage(image, S3Path.CARROSEL))
                    .collect(Collectors.toList())
            );

            company.setRate(Rate.builder()
                    .avg(0.0)
                    .individualRates(new ArrayList<>())
                    .build());

            company.getOwner().setPassword(cryptPasswordGateway.execute(company.getOwner().getPassword()));

            companyRepository.save(company);
        } catch (Exception e) {
            throw new CompanyServiceException("Error to save company", e);
        }
    }
}
