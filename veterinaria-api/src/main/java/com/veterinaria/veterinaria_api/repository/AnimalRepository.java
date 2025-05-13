package com.veterinaria.veterinaria_api.repository;

import com.veterinaria.veterinaria_api.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
