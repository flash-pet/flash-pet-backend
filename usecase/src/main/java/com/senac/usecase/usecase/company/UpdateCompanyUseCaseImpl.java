package com.senac.usecase.usecase.company;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senac.adapter.gateway.cripto.CryptPasswordGateway;
import com.senac.adapter.gateway.s3.interactor.S3Interact;
import com.senac.adapter.repository.CompanyRepository;
import com.senac.commons.enums.S3Path;
import com.senac.domain.entity.Company;
import com.senac.usecase.exception.CompanyServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UpdateCompanyUseCaseImpl implements UpdateCompanyUseCase {

    private final CompanyRepository companyRepository;
    private final S3Interact s3Interact;
    private final CryptPasswordGateway cryptPasswordGateway;

    @Override
    public void execute(Company company) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {

            final Company entity = companyRepository.findById(company.getId())
                    .orElseThrow(() -> new CompanyServiceException("Invalid company id"));

            if(company.getCarrosel() != null) {
                entity.getCarrosel().forEach(url -> s3Interact.deleteImage(url, S3Path.CARROSEL));

                company.setCarrosel(company.getCarrosel().stream()
                        .map(image -> s3Interact.saveImage(image, S3Path.CARROSEL))
                        .collect(Collectors.toList())
                );
            }

            if(company.getLogo() != null) {
                s3Interact.deleteImage(entity.getLogo(), S3Path.LOGO);

                company.setLogo(s3Interact.saveImage(company.getLogo(), S3Path.LOGO));
            }

            final String entityJson = mapper.writeValueAsString(company);

            final Company entityUpdated = mapper.readerForUpdating(entity).readValue(entityJson);

            if(company.getOwner().getPassword() != null || !company.getOwner().getPassword().isBlank()) {
                entityUpdated.getOwner().setPassword(cryptPasswordGateway.execute(company.getOwner().getPassword()));
            }

            companyRepository.save(entityUpdated);
        } catch (Exception e) {
            throw new CompanyServiceException("Error to save company", e);
        }
    }
}
