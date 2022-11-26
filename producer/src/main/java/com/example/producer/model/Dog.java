package com.example.producer.model;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dog {
    private String name;
    private String breed;
    private String gender;
    private String age;

    public Dog() {
        Faker faker = new Faker();
        com.github.javafaker.Dog dog = faker.dog();
        this.name = dog.name();
        this.breed = dog.breed();
        this.gender = dog.gender();
        this.age = dog.age();
    }
}
