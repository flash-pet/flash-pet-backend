package com.senac.domain.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OwnerOut {
    private String userName;
    private String password;
}
