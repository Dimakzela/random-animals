package com.dk.randomanimal.service;

import com.dk.randomanimal.config.ApplicationProperties;
import com.dk.randomanimal.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AnimalService {


    private final ApplicationProperties properties;
    private final RestTemplate restTemplate;

    @Autowired
    public AnimalService(ApplicationProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    public Animal getRandomAnimal() {
        return restTemplate.getForObject(properties.getUrl(), Animal.class);
    }

    public Animal[] getRandomAnimals(int count) {
        return restTemplate.getForEntity(properties.getUrl() + "/"+count, Animal[].class).getBody();
    }
}
