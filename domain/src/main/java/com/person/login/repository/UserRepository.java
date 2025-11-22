package com.person.login.repository;

import com.person.login.entity.User;

public interface UserRepository {
    User save(User user);
    User findByUsername(String username);
}