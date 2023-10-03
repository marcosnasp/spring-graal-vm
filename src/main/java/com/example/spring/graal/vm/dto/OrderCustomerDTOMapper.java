package com.example.spring.graal.vm.dto;

import com.example.spring.graal.vm.model.OrderCustomer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderCustomerDTOMapper implements Function<OrderCustomer, OrderCustomerDTO> {

    private final OrderItemDTOMapper orderItemDTOMapper;

    public OrderCustomerDTOMapper(OrderItemDTOMapper orderItemDTOMapper) {
        this.orderItemDTOMapper = orderItemDTOMapper;
    }

    @Override
    public OrderCustomerDTO apply(OrderCustomer orderCustomer) {
        List<OrderItemDTO> orderItemsDTO = orderCustomer.getOrderItems().stream().map(orderItemDTOMapper).collect(Collectors.toList());
        return new OrderCustomerDTO(orderCustomer.getOrderDate(), orderCustomer.getTotalAmount(), orderItemsDTO);
    }
}
