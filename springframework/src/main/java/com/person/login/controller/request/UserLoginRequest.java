package com.person.login.controller.request;

public record UserLoginRequest(
        String username,
        String password,
        String email
) {
}
