package com.person.login.entity;

public record User(
    String id,
    String username,
    String password,
    String email
) {
}