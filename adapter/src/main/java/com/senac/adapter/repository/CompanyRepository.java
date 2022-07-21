package com.senac.adapter.repository;


import com.senac.domain.entity.Company;
import org.springframework.data.elasticsearch.core.SearchScrollHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CompanyRepository extends ElasticsearchRepository<Company, String> {
    Company findCompanyByOwnerUsername(String username);
    SearchScrollHits<Company> findCompaniesByOwnerUsername(String username);
}
