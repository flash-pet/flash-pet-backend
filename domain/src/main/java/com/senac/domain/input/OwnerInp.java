package com.senac.domain.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OwnerInp {
    private String username;
    private String password;
    private String email;
    private String cnpj;
    private String id;
}
