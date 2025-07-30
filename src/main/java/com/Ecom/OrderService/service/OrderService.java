package com.Ecom.OrderService.service;

import com.Ecom.OrderService.dto.CreateOrderResponseDTO;
import com.Ecom.OrderService.dto.OrderItemDTO;
import com.Ecom.OrderService.dto.OrderRequestDTO;
import com.Ecom.OrderService.entity.Order;
import com.Ecom.OrderService.entity.OrderItem;
import com.Ecom.OrderService.mapper.OrderMapper;
import com.Ecom.OrderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;

    public OrderService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO request){
      //persist the order in the order table > OrderRequestDTO > Order Entity
        Order order = OrderMapper.toEntity(request);
        Order createdOrder = orderRepository.save(order);

        List<OrderItem> items = new ArrayList<>();

        for(OrderItemDTO itemDTO : request.getItems()){

            //fetch the product details for every item
        }



    }

}
