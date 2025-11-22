package com.person.login.controller.response;

public record UserResponse(
        String id,
        String username,
        String email
) {
}