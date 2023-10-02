package com.example.spring.graal.vm.dto;

import com.example.spring.graal.vm.model.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PublisherDTOMapper implements Function<Publisher, PublisherDTO> {

    private final BookDTOMapper bookDTOMapper;

    public PublisherDTOMapper(BookDTOMapper bookDTOMapper) {
        this.bookDTOMapper = bookDTOMapper;
    }

    @Override
    public PublisherDTO apply(Publisher publisher) {
        List<BookDTO> books = publisher.getBooks().stream().map(bookDTOMapper).collect(Collectors.toList());
        return new PublisherDTO(publisher.getName(), publisher.getAddress(), publisher.getPhoneNumber(), books);
    }
}
