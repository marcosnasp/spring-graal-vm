package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.dto.BookCategoryDTO;
import com.example.spring.graal.vm.dto.BookCategoryDTOMapper;
import com.example.spring.graal.vm.repository.BookCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookCategoryService {

    private final BookCategoryRepository bookCategoryRepository;
    private final BookCategoryDTOMapper bookCategoryDTOMapper;

    public BookCategoryService(BookCategoryRepository bookCategoryRepository, BookCategoryDTOMapper bookCategoryDTOMapper) {
        this.bookCategoryRepository = bookCategoryRepository;
        this.bookCategoryDTOMapper = bookCategoryDTOMapper;
    }

    public Page<BookCategoryDTO> findAll(Pageable pageable) {
        return bookCategoryRepository.findAll(pageable).map(bookCategoryDTOMapper);
    }
}
