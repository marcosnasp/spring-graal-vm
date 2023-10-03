package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.dto.CustomerDTO;
import com.example.spring.graal.vm.dto.CustomerDTOMapper;
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
    private final CustomerDTOMapper customerDTOMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerDTOMapper customerDTOMapper) {
        this.customerRepository = customerRepository;
        this.customerDTOMapper = customerDTOMapper;
    }

    public Page<CustomerDTO> findAll(Pageable page) {
        return customerRepository.findAll(page).map(customerDTOMapper);
    }

    public Optional<CustomerDTO> findById(Integer id) {
        return customerRepository.findById(id).map(customerDTOMapper);
    }

}
