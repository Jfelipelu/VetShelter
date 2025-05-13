package com.veterinaria.veterinaria_api.repository;

import com.veterinaria.veterinaria_api.model.Anfibios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnfibiosRepository extends JpaRepository<Anfibios, Long> {
    List<Anfibios> findByAvailable(boolean available);
    List<Anfibios> findByVaccine(boolean vaccine);
    List<Anfibios> findByHealthIgnoreCase(String health);
    List<Anfibios> findByBreedIgnoreCase(String breed);
    List<Anfibios> findByAgeLessThanEqual(int age);
}
