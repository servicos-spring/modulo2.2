package br.com.fatec.login.security;

import br.com.fatec.login.entity.User;
import br.com.fatec.login.entity.repository.UserRepository;
import br.com.fatec.login.security.dto.AuthUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsSecurity implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsSecurity(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
        User user = repository.findByUsername(nomeUsuario);
        return new AuthUserDetails(user);
    }
}
