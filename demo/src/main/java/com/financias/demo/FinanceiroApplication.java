package com.financias.demo;

import com.financias.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinanceiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceiroApplication.class, args);
    }

    @Bean
CommandLineRunner init(UserService userService) {
    return args -> {
        if (!userService.existeUsuario("admin")) {
            userService.criarUsuario("admin", "123");
            System.out.println("USUÁRIO ADMIN CRIADO");
        }
    };
  }
}

