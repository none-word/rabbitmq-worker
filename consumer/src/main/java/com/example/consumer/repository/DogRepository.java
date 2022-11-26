package com.example.consumer.repository;

import com.example.consumer.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Integer> {
}
