package com.example.spring.graal.vm.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record OrderCustomerDTO(Date orderDate, BigDecimal totalAmount, List<OrderItemDTO> orderItems) {

}
