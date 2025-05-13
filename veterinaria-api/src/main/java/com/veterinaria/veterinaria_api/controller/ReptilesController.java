package com.veterinaria.veterinaria_api.controller;

import com.veterinaria.veterinaria_api.model.Reptiles;
import com.veterinaria.veterinaria_api.service.ReptilesService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reptiles")
@CrossOrigin(origins = "*")
public class ReptilesController {

    private final ReptilesService reptilService;

    public ReptilesController(ReptilesService reptilService) {
        this.reptilService = reptilService;
    }

    @GetMapping
    public List<Reptiles> getAll() {
        return reptilService.getAll();
    }

    @PostMapping
    public ResponseEntity<Reptiles> create(@Valid @RequestBody Reptiles reptil) {
        Reptiles saved = reptilService.save(reptil);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/available")
    public List<Reptiles> getAvailable() {
        return reptilService.getAvailable();
    }

    @GetMapping("/vaccine/{vaccine}")
    public List<Reptiles> getByVaccine(@PathVariable boolean vaccine) {
        return reptilService.getByVaccine(vaccine);
    }
}