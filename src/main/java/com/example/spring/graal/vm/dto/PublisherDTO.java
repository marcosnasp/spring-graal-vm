package com.example.spring.graal.vm.dto;

import java.util.List;

public record PublisherDTO(String name, String address, String phoneNumber, List<BookDTO> books) {
}
