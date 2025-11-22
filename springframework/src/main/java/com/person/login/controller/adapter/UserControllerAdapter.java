package com.person.login.controller.adapter;

import com.person.login.controller.request.UserLoginRequest;
import com.person.login.controller.request.UserRequest;
import com.person.login.entity.User;

import java.util.UUID;

public class UserControllerAdapter {
    private UserControllerAdapter() {
    }

    public static User cast(UserRequest request) {
        return new User(
                UUID.randomUUID().toString(),
                request.username(),
                request.password(),
                request.email()
        );
    }

    public static User cast(UserLoginRequest request) {
        return new User(
                UUID.randomUUID().toString(),
                request.username(),
                request.password(),
                request.email()
        );
    }
}