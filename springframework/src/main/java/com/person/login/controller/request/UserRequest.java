package com.person.login.controller.request;

public record UserRequest(
        String username,
        String password,
        String email
) {
}
