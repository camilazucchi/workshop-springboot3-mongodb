package com.nelioalves.workshopmongo.controller;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/* Essa anotação marca a classe como um controlador que irá lidar com requisições HTTP em uma aplicação web. */
@RequestMapping(value = "/posts")
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

}