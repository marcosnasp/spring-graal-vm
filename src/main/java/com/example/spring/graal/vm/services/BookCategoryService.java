package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.model.BookCategory;
import com.example.spring.graal.vm.repository.BookCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookCategoryService {

    private final BookCategoryRepository bookCategoryRepository;

    public BookCategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public Page<BookCategory> findAll(Pageable pageable) {
        return bookCategoryRepository.findAll(pageable);
    }
}
