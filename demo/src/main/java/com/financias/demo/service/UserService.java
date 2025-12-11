package com.financias.demo.service;

import com.financias.demo.model.User;
import com.financias.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        if (user == null) {

            throw new UsernameNotFoundException("Usuário não encontrado: " + username); 
        }
        
        return (UserDetails) user; 
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}