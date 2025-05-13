package com.veterinaria.veterinaria_api.repository;

import com.veterinaria.veterinaria_api.model.Reptiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReptilesRepository extends JpaRepository<Reptiles, Long> {
    List<Reptiles> findByAvailable(boolean available);
    List<Reptiles> findByVaccine(boolean vaccine);
    List<Reptiles> findByHealthIgnoreCase(String health);
    List<Reptiles> findByBreedIgnoreCase(String breed);
    List<Reptiles> findByAgeLessThanEqual(int age);
}