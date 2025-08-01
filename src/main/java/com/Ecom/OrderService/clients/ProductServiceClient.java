package com.Ecom.OrderService.clients;

import com.Ecom.OrderService.dto.ProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ProductServiceClient {
    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public ProductDTO getProductById(Long productId){

        String url = "http://ECOMMERCESPRING/api/products/" + productId;

        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
        return response.getBody();
    }
}
