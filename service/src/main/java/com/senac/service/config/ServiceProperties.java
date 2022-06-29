package com.senac.service.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ServiceProperties {

    @Value("${service.scroll-time}")
    private Long scrollTime;

    @Value("${service.bucket-name}")
    private String bucketName;

    @Value("${service.cache-size}")
    private Integer cacheSize;

    @Value("${service.cache-duration}")
    private Integer cacheDuration;
}
