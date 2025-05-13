package com.veterinaria.veterinaria_api.repository;

import com.veterinaria.veterinaria_api.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findByAnimalId(Long animalId);
    long countByTypeIgnoreCase(String type);
}
