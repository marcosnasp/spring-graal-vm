package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.dto.BookCategoryDTO;
import com.example.spring.graal.vm.dto.BookCategoryDTOMapper;
import com.example.spring.graal.vm.repository.BookCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    private final BookCategoryRepository bookCategoryRepository;
    private final BookCategoryDTOMapper bookCategoryDTOMapper;

    public CategoryService(BookCategoryRepository bookCategoryRepository, BookCategoryDTOMapper bookCategoryDTOMapper) {
        this.bookCategoryRepository = bookCategoryRepository;
        this.bookCategoryDTOMapper = bookCategoryDTOMapper;
    }

    public Page<BookCategoryDTO> findAll(Pageable page) {
        return bookCategoryRepository.findAll(page).map(bookCategoryDTOMapper);
    }

    public Optional<BookCategoryDTO> findById(Integer id) {
        return bookCategoryRepository.findById(id).map(bookCategoryDTOMapper);
    }

}
