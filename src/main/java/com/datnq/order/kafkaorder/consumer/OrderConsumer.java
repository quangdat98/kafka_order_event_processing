package com.datnq.order.kafkaorder.consumer;

import com.datnq.order.kafkaorder.model.OrderCreatedEvent;
import com.datnq.order.kafkaorder.service.OrderService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private final OrderService service;

    public OrderConsumer(OrderService service) {
        this.service = service;
    }

    @KafkaListener(topics = "order-events", groupId = "order-group")
    public void consume(OrderCreatedEvent event) {
        System.out.println("Consumed order: " + event.getOrderId());
        service.saveOrder(event);
    }
}
