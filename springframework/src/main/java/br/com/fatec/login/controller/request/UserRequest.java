package br.com.fatec.login.controller.request;

import java.util.List;

public record UserRequest(
        String username,
        String password,
        String email
) {
}
