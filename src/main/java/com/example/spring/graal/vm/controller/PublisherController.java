package com.example.spring.graal.vm.controller;

import com.example.spring.graal.vm.exceptions.PublisherNotFoundException;
import com.example.spring.graal.vm.model.Publisher;
import com.example.spring.graal.vm.services.PublisherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Page<Publisher>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(publisherService.findAll(pageable));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Publisher>> findById(@PathVariable("id") Integer id) {
        Optional<Publisher> publisher = publisherService.findById(id);
        if (publisher.isEmpty()) {
            throw new PublisherNotFoundException(String.format("id-: %d", id));
        }
        return ResponseEntity.status(HttpStatus.OK).body(publisherService.findById(id));
    }

}
