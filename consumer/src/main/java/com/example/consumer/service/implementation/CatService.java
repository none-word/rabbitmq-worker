package com.example.consumer.service.implementation;

import com.example.consumer.model.Animal;
import com.example.consumer.model.Cat;
import com.example.consumer.repository.CatRepository;
import com.example.consumer.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CatService implements AnimalService {
    private final CatRepository catRepository;

    @Override
    public void saveAnimal(Animal animal) {
        catRepository.save((Cat) animal);
    }
}
