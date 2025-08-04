package com.datnq.order.kafkaorder.deadletter;

import com.datnq.order.kafkaorder.model.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeadLetterListener {
    @KafkaListener(topics = "order-events.DLT", groupId = "dead-group")
    public void handleDLT(OrderCreatedEvent event) {
        System.err.println("Moved to DeadLetter: " + event.getOrderId());
    }
}
