package br.com.fatec.login.controller.request;

public record UserRequest(
        String username,
        String password,
        String email
) {
}
