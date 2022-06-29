package com.senac.infrastructure.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class InfraProperties {

    @Value("${infra.aws.access-key}")
    private String accessKey;

    @Value("${infra.aws.secret-key}")
    private String secretKey;

    @Value("${infra.aws.open-search.url}")
    private String openSearchUrl;
}
