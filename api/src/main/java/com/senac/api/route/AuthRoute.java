package com.senac.api.route;

import com.senac.api.dto.JwtRequest;
import com.senac.api.dto.JwtResponse;
import com.senac.security.service.UserDetailsServiceImpl;
import com.senac.security.utils.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthRoute implements AuthenticateApiDelegate {

    private AuthenticationManager authenticationManager;

    private JwtTokenUtil jwtTokenUtil;

    private UserDetailsServiceImpl userDetailsService;

    @Override
    public ResponseEntity<JwtResponse> auth(JwtRequest body) {
        authenticate(body.getUsername(), body.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(body.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        final JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(token);

        return ResponseEntity.ok(jwtResponse);
    }

    private void authenticate(String username, String password) throws RuntimeException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new RuntimeException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("INVALID_CREDENTIALS", e);
        }
    }
}
