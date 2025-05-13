package com.veterinaria.veterinaria_api.repository;

import com.veterinaria.veterinaria_api.model.Ave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AveRepository extends JpaRepository<Ave, Long> {
    List<Ave> findByAvailable(boolean available);
    List<Ave> findByVaccine(boolean vaccine);
    List<Ave> findByHealthIgnoreCase(String health);
    List<Ave> findByBreedIgnoreCase(String breed);
    List<Ave> findByAgeLessThanEqual(int age);
    List<Ave> findByCanFly(boolean canFly);
}