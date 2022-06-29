package com.senac.domain.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OwnerOut {
    private String id;
    private String username;
    private String email;
    private String password;
    private String cnpj;
}
