package com.senac.adapter.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AdapterProperties {

    @Value("${adapter.aws.access-key}")
    private String accessKey;

    @Value("${adapter.aws.secret-key}")
    private String secretKey;

    @Value("${adapter.aws.open-search.url}")
    private String openSearchUrl;

    @Value("${adapter.aws.s3.bucket-name}")
    private String bucketName;

    @Value("${adapter.cache-size}")
    private Integer cacheSize;

    @Value("${adapter.cache-duration}")
    private Integer cacheDuration;
}
