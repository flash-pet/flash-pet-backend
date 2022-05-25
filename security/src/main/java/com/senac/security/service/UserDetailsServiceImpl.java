package com.senac.security.service;

import com.senac.domain.output.OwnerOut;
import com.senac.security.exception.SecurityException;
import com.senac.service.OwnerService;
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

    private final OwnerService ownerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final OwnerOut owner = ownerService.getByUsername(username);
        if(username.equals(owner.getUserName())) {
            return new User(username, owner.getPassword(), new ArrayList<>());
        } else {
            throw new SecurityException("User not found with username: " + username);
        }
    }
}
