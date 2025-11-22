package com.person.login.controller;

import com.person.login.controller.adapter.UserControllerAdapter;
import com.person.login.controller.request.UserRequest;
import com.person.login.controller.response.UserResponse;
import com.person.login.entity.User;
import com.person.login.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth/users")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public UserResponse save(@RequestBody UserRequest request) {
        User save = repository.save(UserControllerAdapter.cast(request));
        return new UserResponse(
                save.id(),
                save.username(),
                save.email()
        );
    }
}
