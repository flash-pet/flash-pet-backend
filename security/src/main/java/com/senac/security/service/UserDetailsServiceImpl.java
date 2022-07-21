package com.senac.security.service;

import com.senac.domain.entity.Owner;
import com.senac.security.exception.SecurityException;
import com.senac.usecase.usecase.owner.GetOwnerByUserNameUseCase;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final GetOwnerByUserNameUseCase ownerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Owner owner = ownerService.getByUsername(username);
        if(username.equals(owner.getUsername())) {
            return new User(username, owner.getPassword(), new ArrayList<>());
        } else {
            throw new SecurityException("User not found with username: " + username);
        }
    }
}
