package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.model.BookCategory;
import com.example.spring.graal.vm.repository.BookCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    private final BookCategoryRepository bookCategoryRepository;

    public CategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public Page<BookCategory> findAll(Pageable page) {
        return bookCategoryRepository.findAll(page);
    }

}
