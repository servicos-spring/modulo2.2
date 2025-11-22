package br.com.fatec.login.controller;

import br.com.fatec.login.controller.adapter.UserControllerAdapter;
import br.com.fatec.login.controller.request.UserRequest;
import br.com.fatec.login.controller.response.AuthResponse;
import br.com.fatec.login.entity.Token;
import br.com.fatec.login.security.TokenSecurity;
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
    public AuthResponse login(@RequestBody UserRequest request) {
        Token token = tokenSecurity.generateToken(UserControllerAdapter.cast(request));
        return new AuthResponse(token.value());
    }
}