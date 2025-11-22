package com.person.login.security;

import com.person.login.entity.Token;
import com.person.login.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class TokenSecurity {
    private final AuthenticationManager authenticationManager;
    private final JWTSecurity jwtSecurity;
    private final UserDetailsService userDetailsService;

    public TokenSecurity(JWTSecurity jwtSecurity, UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.jwtSecurity = jwtSecurity;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    public Token generateToken(User user) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.username(), user.password());
        authenticationManager.authenticate(authToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.username());
        return new Token(jwtSecurity.generateToken(userDetails));
    }
}
