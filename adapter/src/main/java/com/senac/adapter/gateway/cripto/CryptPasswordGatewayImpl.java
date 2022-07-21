package com.senac.adapter.gateway.cripto;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CryptPasswordGatewayImpl implements CryptPasswordGateway {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public String execute(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
