package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.model.Author;
import com.example.spring.graal.vm.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

}
