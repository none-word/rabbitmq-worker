package com.example.producer.model;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cat {
    private String name;
    private String breed;

    public Cat() {
        Faker faker = new Faker();
        com.github.javafaker.Cat cat = faker.cat();
        this.name = cat.name();
        this.breed = cat.breed();
    }
}
