package com.example.producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueueInitializer implements CommandLineRunner {
    private final QueueSender queueSender;
    @Override
    public void run(String... args) throws Exception {
        queueSender.send("Initialize queue...");
    }
}
