package com.veterinaria.veterinaria_api.service;

import com.veterinaria.veterinaria_api.model.Animal;
import com.veterinaria.veterinaria_api.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Optional<Animal> findById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal update(Long id, Animal animalDetails) {
        Optional<Animal> existingAnimal = animalRepository.findById(id);

        if (existingAnimal.isPresent()) {
            Animal animalToUpdate = existingAnimal.get();

            animalToUpdate.setName(animalDetails.getName());
            animalToUpdate.setSpecies(animalDetails.getSpecies());
            animalToUpdate.setBreed(animalDetails.getBreed());
            animalToUpdate.setAge(animalDetails.getAge());
            animalToUpdate.setHealth(animalDetails.getHealth());
            animalToUpdate.setAvailable(animalDetails.isAvailable());
            animalToUpdate.setVaccine(animalDetails.isVaccine());
            animalToUpdate.setAdmissionDate(animalDetails.getAdmissionDate());
            animalToUpdate.setTransactionDate(animalDetails.getTransactionDate());

            return animalRepository.save(animalToUpdate);
        } else {
            return null;
        }
    }
}