package com.Ecom.OrderService.service;

import com.Ecom.OrderService.clients.ProductServiceClient;
import com.Ecom.OrderService.dto.CreateOrderResponseDTO;
import com.Ecom.OrderService.dto.OrderItemDTO;
import com.Ecom.OrderService.dto.OrderRequestDTO;
import com.Ecom.OrderService.dto.ProductDTO;
import com.Ecom.OrderService.entity.Order;
import com.Ecom.OrderService.entity.OrderItem;
import com.Ecom.OrderService.mapper.OrderItemMapper;
import com.Ecom.OrderService.mapper.OrderMapper;
import com.Ecom.OrderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final ProductServiceClient productClient;

    public OrderService (OrderRepository orderRepository, ProductServiceClient productClient){
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO request){
      //persist the order in the order table > OrderRequestDTO > Order Entity
        Order order = OrderMapper.toEntity(request);


        List<OrderItem> items = new ArrayList<>();

        for(OrderItemDTO itemDTO : request.getItems()){

            //fetch the product details for every item
            ProductDTO product = productClient.getProductById(itemDTO.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit * itemDTO.getQuantity();

            OrderItem item = OrderItemMapper.OrderItemRequestDTOtoOrderItemEntity(
                    itemDTO,
                    order,
                    pricePerUnit,
                    totalPrice
            );
            items.add(item);
        }
        order.setItems(items);
        Order createdOrder = orderRepository.save(order);

        return  OrderMapper.toCreateOrderResponseDTO(createdOrder);



    }

}
