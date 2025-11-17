package br.com.fatec.login.controller;

import br.com.fatec.login.controller.adapter.UserControllerAdapter;
import br.com.fatec.login.controller.request.UserRequest;
import br.com.fatec.login.controller.response.UserResponse;
import br.com.fatec.login.entity.User;
import br.com.fatec.login.entity.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
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
