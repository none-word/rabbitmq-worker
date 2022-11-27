package com.example.consumer.service.implementation;

import com.example.consumer.model.Dog;
import com.example.consumer.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class DogService {
    private final DogRepository dogRepository;

    public void saveAnimal(Dog dog) {
        log.info("Saving dog");
        dogRepository.save(dog);
    }
}
