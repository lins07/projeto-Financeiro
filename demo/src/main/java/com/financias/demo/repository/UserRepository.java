package com.financias.demo.repository;

import com.financias.demo.model.User;
import org.apache.commons.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Log> {
    User findByUsername(String username);
    
}
