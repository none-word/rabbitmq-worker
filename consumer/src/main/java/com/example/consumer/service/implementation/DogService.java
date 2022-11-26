package com.example.consumer.service.implementation;

import com.example.consumer.model.Animal;
import com.example.consumer.model.Dog;
import com.example.consumer.repository.DogRepository;
import com.example.consumer.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DogService implements AnimalService {
    private final DogRepository dogRepository;

    @Override
    public void saveAnimal(Animal animal) {
        dogRepository.save((Dog) animal);
    }
}
