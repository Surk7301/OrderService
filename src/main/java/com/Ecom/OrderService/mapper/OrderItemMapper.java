package com.Ecom.OrderService.mapper;

import com.Ecom.OrderService.dto.OrderItemDTO;
import com.Ecom.OrderService.entity.Order;
import com.Ecom.OrderService.entity.OrderItem;

public class OrderItemMapper {
    public static OrderItem OrderItemRequestDTOtoOrderItemEntity(OrderItemDTO itemDTO, Order order, double pricePerUnit, double totalPrice){

        return OrderItem.builder()
                .productId(itemDTO.getProductId())
                .quantity(itemDTO.getQuantity())
                .pricePerUnit(pricePerUnit)
                .totalPrice(totalPrice)
                .order(order)
                .build();
    }
}
