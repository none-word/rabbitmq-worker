package com.example.consumer.service.queue;

import com.example.consumer.model.Animal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class QueueReceiver {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = {"${queue.name}"})
    public void receiveMessage(@Payload String message) {
        log.info("Message has been received successfully. Message content: {}", message);
        try {
            Animal animal = objectMapper.readValue(message, Animal.class);
        } catch (JsonProcessingException e) {
            log.info("Initialized message");
        }
    }
}
