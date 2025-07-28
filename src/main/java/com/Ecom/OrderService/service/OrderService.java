package com.Ecom.OrderService.service;

import com.Ecom.OrderService.dto.CreateOrderResponseDTO;
import com.Ecom.OrderService.dto.OrderRequestDTO;
import com.Ecom.OrderService.entity.Order;
import com.Ecom.OrderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;

    public OrderService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO request){
      //persist the order in the order table > OrderRequestDTO > Order Entity

    }

}
