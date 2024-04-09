package com.nelioalves.workshopmongo.controller;

import com.nelioalves.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
/* Essa anotação marca a classe como um controlador que irá lidar com requisições HTTP em uma aplicação web. */
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> users = new ArrayList<>(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(users);
    }

}