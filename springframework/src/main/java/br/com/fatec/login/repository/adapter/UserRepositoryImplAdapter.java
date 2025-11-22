package br.com.fatec.login.repository.adapter;

import br.com.fatec.login.entity.User;
import br.com.fatec.login.repository.orm.UserOrm;
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
