package com.veterinaria.veterinaria_api.controller;

import com.veterinaria.veterinaria_api.dto.MetricasDTO;
import com.veterinaria.veterinaria_api.model.Animal;
import com.veterinaria.veterinaria_api.repository.AnimalRepository;
import com.veterinaria.veterinaria_api.repository.TransaccionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/stats")
public class MetricasController {

    private final AnimalRepository animalRepository;
    private final TransaccionRepository transaccionRepository;

    public MetricasController(AnimalRepository animalRepository, TransaccionRepository transaccionRepository) {
        this.animalRepository = animalRepository;
        this.transaccionRepository = transaccionRepository;
    }

    @GetMapping
    public MetricasDTO obtenerMetricas() {
        MetricasDTO stats = new MetricasDTO();

        stats.setTotalAnimales(animalRepository.count());
        stats.setTotalAdopciones(transaccionRepository.countByTypeIgnoreCase("adopción"));
        stats.setTotalAcogidas(transaccionRepository.countByTypeIgnoreCase("acogida"));

        Map<String, Long> porEspecie = new HashMap<>();
        for (Animal a : animalRepository.findAll()) {
            porEspecie.merge(a.getSpecies().toLowerCase(), 1L, Long::sum);
        }
        stats.setTotalPorEspecie(porEspecie);

        return stats;
    }
}
