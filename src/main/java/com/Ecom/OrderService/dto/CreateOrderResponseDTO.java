package com.Ecom.OrderService.dto;

import com.Ecom.OrderService.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderResponseDTO {
    private Long OrderId;
    private OrderStatus status;
}
