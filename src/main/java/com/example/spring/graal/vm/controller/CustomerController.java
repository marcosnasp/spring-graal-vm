package com.example.spring.graal.vm.controller;


import com.example.spring.graal.vm.dto.CustomerDTO;
import com.example.spring.graal.vm.exceptions.CustomerNotFoundException;
import com.example.spring.graal.vm.services.CustomerService;
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

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Page<CustomerDTO>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable page) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll(page));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<CustomerDTO>> findById(@PathVariable("id") Integer id) throws CustomerNotFoundException {
        Optional<CustomerDTO> customer = customerService.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException(String.format("id-: %d", id));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(customer);
        }
    }

}
