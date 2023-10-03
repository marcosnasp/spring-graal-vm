package com.example.spring.graal.vm.dto;

import com.example.spring.graal.vm.model.BookCategory;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BookCategoryDTOMapper implements Function<BookCategory, BookCategoryDTO> {
    @Override
    public BookCategoryDTO apply(BookCategory bookCategory) {
        return new BookCategoryDTO(bookCategory.getName());
    }
}
