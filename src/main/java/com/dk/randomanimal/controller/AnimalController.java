package com.dk.randomanimal.controller;

import com.dk.randomanimal.model.Animal;
import com.dk.randomanimal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getRandomAnimals(@RequestParam("count") Optional<Integer> count) {
        return count.map(integer -> Arrays.asList(animalService.getRandomAnimals(integer))).orElseGet(() -> List.of(animalService.getRandomAnimal()));
    }
}
