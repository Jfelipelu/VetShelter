package com.veterinaria.veterinaria_api.repository;

import com.veterinaria.veterinaria_api.model.Canino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaninoRepository extends JpaRepository<Canino, Long> {
    List<Canino> findByAvailable(boolean available);
    List<Canino> findByHealthIgnoreCase(String health);
    List<Canino> findByVaccine(boolean vaccine);
    List<Canino> findByBreedIgnoreCase(String breed);
    List<Canino> findByAgeLessThanEqual(int age);
}
