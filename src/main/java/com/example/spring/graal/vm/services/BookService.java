package com.example.spring.graal.vm.services;

import com.example.spring.graal.vm.dto.BookDTO;
import com.example.spring.graal.vm.dto.BookDTOMapper;
import com.example.spring.graal.vm.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    private final BookDTOMapper bookDTOMapper;

    public BookService(BookRepository bookRepository, BookDTOMapper bookDTOMapper) {
        this.bookRepository = bookRepository;
        this.bookDTOMapper = bookDTOMapper;
    }

    public Page<BookDTO> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookDTOMapper);
    }
}
