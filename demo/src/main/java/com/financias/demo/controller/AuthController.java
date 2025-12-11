package com.financias.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // CORREÇÃO: Mapeia a raiz ('/') e o '/login'
    @GetMapping({"/", "/login"})
    public String login() {
        return "login"; // Retorna o template login.html
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}