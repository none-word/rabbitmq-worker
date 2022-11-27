package com.example.consumer.service.queue;

import com.example.consumer.model.Cat;
import com.example.consumer.model.Dog;
import com.example.consumer.service.implementation.CatService;
import com.example.consumer.service.implementation.DogService;
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
    private final CatService catService;
    private final DogService dogService;

    @RabbitListener(queues = {"${queue.name}"})
    public void receiveMessage(@Payload String message) {
        log.info("Message has been received successfully. Message content: {}", message);
        try {
            Cat cat = objectMapper.readValue(message, Cat.class);
            catService.saveAnimal(cat);
        } catch (JsonProcessingException e) {
            try {
                Dog dog = objectMapper.readValue(message, Dog.class);
                dogService.saveAnimal(dog);
            } catch (JsonProcessingException ex) {
                log.info("Initialized message");
            }
        }
    }
}
