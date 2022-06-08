package com.senac.domain.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class CacheExpirationOut {
    private String value;
    private String expiration;
}
