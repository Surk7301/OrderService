package com.Ecom.OrderService.mapper;

import com.Ecom.OrderService.dto.OrderRequestDTO;
import com.Ecom.OrderService.entity.Order;
import com.Ecom.OrderService.enums.OrderStatus;

public class OrderMapper {
    public static Order toEntity(OrderRequestDTO dto){
        return Order.builder()
                .userId(dto.getUserId())
                .status(OrderStatus.PENDING)
                .build();
    }
}
