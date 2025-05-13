package com.veterinaria.veterinaria_api.controller;

import com.veterinaria.veterinaria_api.model.Anfibios;
import com.veterinaria.veterinaria_api.service.AnfibiosService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anfibios")
@CrossOrigin(origins = "*")
public class AnfibiosController {

    private final AnfibiosService anfibiosService;

    public AnfibiosController(AnfibiosService anfibiosService) {
        this.anfibiosService = anfibiosService;
    }

    @GetMapping
    public List<Anfibios> getAll() {
        return anfibiosService.getAll();
    }

    @PostMapping
    public ResponseEntity<Anfibios> create(@Valid @RequestBody Anfibios anfibios) {
        Anfibios saved = anfibiosService.save(anfibios);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/available")
    public List<Anfibios> getAvailable() {
        return anfibiosService.getAvailable();
    }

    @GetMapping("/vaccine/{vaccine}")
    public List<Anfibios> getByVaccine(@PathVariable boolean vaccine) {
        return anfibiosService.getByVaccine(vaccine);
    }
}