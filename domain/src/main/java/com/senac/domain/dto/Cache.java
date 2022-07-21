package com.senac.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cache {
    private String code;
    private String duration;
}
