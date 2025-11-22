package br.com.fatec.login.entity;

public record User(
    String id,
    String username,
    String password,
    String email
) {
}