package com.senac.domain.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class PetShopOut {
    private UUID id;
    private String name;
}
