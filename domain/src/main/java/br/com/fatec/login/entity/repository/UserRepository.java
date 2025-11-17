package br.com.fatec.login.entity.repository;

import br.com.fatec.login.entity.User;

public interface UserRepository {
    User save(User user);

    User findByUsername(String username);
}