package com.person.login.repository.adapter;

import com.person.login.entity.User;
import com.person.login.repository.orm.UserOrm;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRepositoryImplAdapter {
    private UserRepositoryImplAdapter() {
    }

    public static User cast(UserOrm orm, PasswordEncoder passwordEncoder) {
        return new User(
                orm.id(),
                orm.username(),
                passwordEncoder.encode(orm.password()),
                orm.email()
        );
    }


    public static UserOrm cast(User user) {
        return new UserOrm(
                user.id(),
                user.username(),
                user.password(),
                user.email()
        );
    }
}
