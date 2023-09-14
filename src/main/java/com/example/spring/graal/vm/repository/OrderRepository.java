package com.example.spring.graal.vm.repository;

import com.example.spring.graal.vm.model.OrderCostumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderCostumer, Integer> {
}
