package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.model.Category;
import com.example.spring.graal.vm.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<Category> findAll(Pageable page) {
        return categoryRepository.findAll(page);
    }

}
