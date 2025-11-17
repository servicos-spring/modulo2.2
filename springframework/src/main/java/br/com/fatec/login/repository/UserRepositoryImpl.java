package br.com.fatec.login.repository;

import br.com.fatec.login.entity.User;
import br.com.fatec.login.entity.repository.UserRepository;
import br.com.fatec.login.repository.adapter.UserRepositoryImplAdapter;
import br.com.fatec.login.repository.client.UserRepositoryWithMongodb;
import br.com.fatec.login.repository.orm.UserOrm;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final PasswordEncoder encoder;
    private final UserRepositoryWithMongodb repository;

    public UserRepositoryImpl(
            PasswordEncoder encoder,
            UserRepositoryWithMongodb repository) {
        this.encoder = encoder;
        this.repository = repository;
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
