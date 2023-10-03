package com.example.spring.graal.vm.dto;

import com.example.spring.graal.vm.model.Customer;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {

    @Override
    public CustomerDTO apply(Customer customer) {
        return new CustomerDTO(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getAddress(), customer.getPhoneNumber());
    }
}
