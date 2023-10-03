package com.example.spring.graal.vm.dto;

import java.math.BigDecimal;

public record OrderItemDTO(BookDTO bookDTO, int quantity, BigDecimal price) {
}
