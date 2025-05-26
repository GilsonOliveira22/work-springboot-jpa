package com.aprimorapring.aprimora.controller;

import com.aprimorapring.aprimora.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll() {
        // Criando um usuário fictício para retornar
        User user = new User(1L, "Maria", "maria@email.com", "999999999", "12345");
        return ResponseEntity.ok().body(user);
    }
}
