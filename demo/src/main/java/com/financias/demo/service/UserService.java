package com.financias.demo.service;

import com.financias.demo.model.User;
import com.financias.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado"));
    }

    public User criarUsuario(String username, String senha) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(senha));
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }

    public boolean existeUsuario(String username) {
    return userRepository.findByUsername(username).isPresent();
}

}
