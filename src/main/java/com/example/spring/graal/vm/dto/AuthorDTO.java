package com.example.spring.graal.vm.dto;

import com.example.spring.graal.vm.model.Book;

import java.util.Date;
import java.util.List;

public record AuthorDTO(String firstName, String lastName, Date birthDate, String bio, List<BookDTO> books) {
}
