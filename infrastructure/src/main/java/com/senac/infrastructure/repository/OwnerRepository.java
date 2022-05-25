package com.senac.infrastructure.repository;

import com.senac.infrastructure.entity.Owner;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OwnerRepository extends ElasticsearchRepository<Owner, String> {
    Owner findByUsername(String username);
}
