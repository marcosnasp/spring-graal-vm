package com.example.spring.graal.vm.dto;

import com.example.spring.graal.vm.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderItemDTOMapper implements Function<OrderItem, OrderItemDTO> {

    private final BookDTOMapper bookDTOMapper;

    public OrderItemDTOMapper(BookDTOMapper bookDTOMapper) {
        this.bookDTOMapper = bookDTOMapper;
    }

    @Override
    public OrderItemDTO apply(OrderItem orderItem) {
        BookDTO bookDTO = bookDTOMapper.apply(orderItem.getBook());
        return new OrderItemDTO(bookDTO, orderItem.getQuantity(), orderItem.getPrice());
    }
}
