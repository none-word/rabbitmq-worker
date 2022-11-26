package com.example.consumer.repository;

import com.example.consumer.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Integer> {
}
