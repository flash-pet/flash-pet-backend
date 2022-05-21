package com.senac.infrastructure.repository;

import com.senac.infrastructure.entity.Company;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CompanyRepository extends ElasticsearchRepository<Company, String> {
}
