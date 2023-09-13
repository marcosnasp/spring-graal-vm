package com.example.spring.graal.vm.repository;

import com.example.spring.graal.vm.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
