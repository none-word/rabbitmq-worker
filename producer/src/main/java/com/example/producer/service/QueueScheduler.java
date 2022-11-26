package com.example.producer.service;

import com.example.producer.model.Cat;
import com.example.producer.model.Dog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class QueueScheduler {
    private final QueueSender queueSender;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Random random = new Random();

    @Scheduled(fixedRate = 2, timeUnit = TimeUnit.SECONDS)
    public void sendMessage() throws JsonProcessingException {
        String message = createMessage();
        queueSender.send(message);
        log.info("Message has been sent. Message content: {}", message);
    }

    private String createMessage() throws JsonProcessingException {
        String result;
        if (random.nextBoolean()) {
            result = objectMapper.writeValueAsString(new Dog());
        } else {
            result = objectMapper.writeValueAsString(new Cat());
        }
        return result;
    }
}
