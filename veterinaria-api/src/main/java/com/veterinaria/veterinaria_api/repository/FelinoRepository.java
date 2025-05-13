package com.veterinaria.veterinaria_api.repository;

import com.veterinaria.veterinaria_api.model.Felino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FelinoRepository extends JpaRepository<Felino, Long> {
    List<Felino> findByAvailable(boolean available);
    List<Felino> findByVaccine(boolean vaccine);
    List<Felino> findByHealthIgnoreCase(String health);
    List<Felino> findByBreedIgnoreCase(String breed);
    List<Felino> findByAgeLessThanEqual(int age);
}