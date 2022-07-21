package com.senac.usecase.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class UseCaseProperties {

    @Value("${usecase.scroll-time}")
    private Long scrollTime;
}
