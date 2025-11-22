package com.person.login.controller;

import com.person.login.controller.adapter.UserControllerAdapter;
import com.person.login.controller.request.UserLoginRequest;
import com.person.login.controller.request.UserRequest;
import com.person.login.controller.response.AuthResponse;
import com.person.login.entity.Token;
import com.person.login.security.TokenSecurity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    private final TokenSecurity tokenSecurity;

    public AuthController(TokenSecurity tokenSecurity) {
        this.tokenSecurity = tokenSecurity;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public AuthResponse login(@RequestBody UserLoginRequest request) {
        Token token = tokenSecurity.generateToken(UserControllerAdapter.cast(request));
        return new AuthResponse(token.value());
    }
}