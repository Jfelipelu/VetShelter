package com.veterinaria.veterinaria_api.service;

import com.veterinaria.veterinaria_api.model.Animal;
import com.veterinaria.veterinaria_api.model.Transaccion;
import com.veterinaria.veterinaria_api.repository.AnimalRepository;
import com.veterinaria.veterinaria_api.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService {

    private final TransaccionRepository transactionRepository;
    private final AnimalRepository animalRepository;

    public TransaccionService(TransaccionRepository transactionRepository, AnimalRepository animalRepository) {
        this.transactionRepository = transactionRepository;
        this.animalRepository = animalRepository;
    }

    public List<Transaccion> findAll() {
        return transactionRepository.findAll();
    }

    public List<Transaccion> findByAnimal(Long animalId) {
        return transactionRepository.findByAnimalId(animalId);
    }

    public Optional<Transaccion> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaccion save(Transaccion transaction) {
    Animal animal = transaction.getAnimal();

    if (animal == null || animal.getId() == null) {
        throw new RuntimeException("Animal no válido o sin ID");
    }

    Animal existingAnimal = animalRepository.findById(animal.getId())
                .orElseThrow(() -> new RuntimeException("Animal no encontrado"));

        if ("adopción".equalsIgnoreCase(transaction.getType())) {
            existingAnimal.setAvailable(false);
            animalRepository.save(existingAnimal);
        }

        transaction.setAnimal(existingAnimal);
        return transactionRepository.save(transaction);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}
