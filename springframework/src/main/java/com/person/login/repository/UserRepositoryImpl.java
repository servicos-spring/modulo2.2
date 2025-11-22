package com.person.login.repository;

import com.person.login.entity.User;
import com.person.login.repository.adapter.UserRepositoryImplAdapter;
import com.person.login.repository.client.UserRepositoryWithMongodb;
import com.person.login.repository.orm.UserOrm;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserRepositoryWithMongodb repository;
    private final PasswordEncoder encoder;

    public UserRepositoryImpl(UserRepositoryWithMongodb repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public User save(User user) {
        try {
            UserOrm orm = repository.save(UserRepositoryImplAdapter.cast(user));
            return UserRepositoryImplAdapter.cast(orm, encoder);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public User findByUsername(String nomeUsuario) {
        try {
            Optional<UserOrm> optional = repository.findByUsername(nomeUsuario);
            if (optional.isEmpty()) {
                throw new UsernameNotFoundException("Usuario não encontrado");
            }
            return UserRepositoryImplAdapter.cast(optional.get(), encoder);
        } catch (UsernameNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
