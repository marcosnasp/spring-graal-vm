package com.example.spring.graal.vm.controller;

import com.example.spring.graal.vm.dto.AuthorDTO;
import com.example.spring.graal.vm.exceptions.AuthorNotFoundException;
import com.example.spring.graal.vm.services.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Page<AuthorDTO>> getAllAuthors(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.findAll(pageable));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable("id") Integer id) {
        Optional<AuthorDTO> authorDto = authorService.findById(id);
        if (authorDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(authorDto.get());
        } else {
            throw new AuthorNotFoundException(String.format("Author %d Not Found.", id));
        }
    }

}
