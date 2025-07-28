package com.Ecom.OrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

@Builder
public class OrderRequestDTO {
    private long userId;
    private List<OrderItemDTO> items;
}
