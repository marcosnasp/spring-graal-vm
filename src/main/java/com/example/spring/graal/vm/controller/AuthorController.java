package com.example.spring.graal.vm.controller;

import com.example.spring.graal.vm.model.Author;
import com.example.spring.graal.vm.services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAll() {
        return authorService.findAll();
    }
}
