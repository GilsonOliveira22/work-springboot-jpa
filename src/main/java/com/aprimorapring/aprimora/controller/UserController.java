package com.aprimorapring.aprimora.controller;

import com.aprimorapring.aprimora.entities.User;
import com.aprimorapring.aprimora.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        User insert = service.insert(user);
        URI uri = URI.create(String.format("/users/%d", insert.getId()));
        return ResponseEntity.created(uri).body(insert);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delet(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
