package com.example.spring.graal.vm.dto;

import com.example.spring.graal.vm.model.Book;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BookDTOMapper implements Function<Book, BookDTO> {
    @Override
    public BookDTO apply(Book book) {
        return new BookDTO(book.getTitle(), book.getIsbn(), book.getPublicationDate());
    }
}
