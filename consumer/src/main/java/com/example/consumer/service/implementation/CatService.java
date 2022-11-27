package com.example.consumer.service.implementation;

import com.example.consumer.model.Cat;
import com.example.consumer.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class CatService {
    private final CatRepository catRepository;

    public void saveAnimal(Cat cat) {
        log.info("Saving cat");
        catRepository.save(cat);
    }
}
