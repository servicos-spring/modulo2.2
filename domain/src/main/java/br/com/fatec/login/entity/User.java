package br.com.fatec.login.entity;

import java.util.List;

public record User(
        String id,
        String username,
        String password,
        String email
) {
}