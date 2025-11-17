package br.com.fatec.login.controller.adapter;

import br.com.fatec.login.controller.request.UserRequest;
import br.com.fatec.login.entity.User;

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
}