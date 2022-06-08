package com.senac.infrastructure.repository;

import com.senac.infrastructure.entity.Company;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface CompanyRepository extends ElasticsearchRepository<Company, String> {
    Company findCompanyByOwnerUsername(String username);
}
