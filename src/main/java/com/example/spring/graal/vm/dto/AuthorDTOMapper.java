package com.example.spring.graal.vm.dto;

import com.example.spring.graal.vm.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AuthorDTOMapper implements Function<Author, AuthorDTO> {

    private final BookDTOMapper bookDTOMapper;

    public AuthorDTOMapper(BookDTOMapper bookDTOMapper) {
        this.bookDTOMapper = bookDTOMapper;
    }

    @Override
    public AuthorDTO apply(Author author) {
        List<BookDTO> books = author.getBooks().stream().map(bookDTOMapper).collect(Collectors.toList());
        return new AuthorDTO(author.getFirstName(), author.getLastName(), author.getBirthDate(), author.getBio(),
                 books);
    }
}
