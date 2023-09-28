package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.model.Customer;
import com.example.spring.graal.vm.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Page<Customer> findAll(Pageable page) {
        return customerRepository.findAll(page);
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

}
