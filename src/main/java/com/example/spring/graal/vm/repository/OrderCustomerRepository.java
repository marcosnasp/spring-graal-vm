package com.example.spring.graal.vm.repository;

import com.example.spring.graal.vm.model.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCustomerRepository extends JpaRepository<OrderCustomer, Integer> {
}
