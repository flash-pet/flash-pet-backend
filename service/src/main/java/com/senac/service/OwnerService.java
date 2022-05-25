package com.senac.service;

import com.senac.domain.output.OwnerOut;

public interface OwnerService {
    OwnerOut getByUsername(String username);

}
