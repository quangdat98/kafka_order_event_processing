package com.datnq.order.kafkaorder.service;

import com.datnq.order.kafkaorder.entity.OrderEntity;
import com.datnq.order.kafkaorder.model.OrderCreatedEvent;
import com.datnq.order.kafkaorder.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository orderRepository) {
        this.repo = orderRepository;
    }

    public void saveOrder(OrderCreatedEvent event) {
        if ("FAIL".equalsIgnoreCase(event.getProductId())) {
            throw new RuntimeException("Simulated processing failure");
        }
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(event.getOrderId());
        entity.setProductId(event.getProductId());
        entity.setQuantity(event.getQuantity());
        entity.setPrice(event.getPrice());
        entity.setCreatedAt(event.getCreatedAt());
        repo.save(entity);
    }
}
