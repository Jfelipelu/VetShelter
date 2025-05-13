package com.veterinaria.veterinaria_api.controller;

import com.veterinaria.veterinaria_api.model.Felino;
import com.veterinaria.veterinaria_api.service.FelinoService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/felinos")
@CrossOrigin(origins = "*")
public class FelinoController {

    private final FelinoService felinoService;

    public FelinoController(FelinoService felinoService) {
        this.felinoService = felinoService;
    }

    @GetMapping
    public List<Felino> getAll() {
        return felinoService.getAll();
    }

    @PostMapping
    public ResponseEntity<Felino> create(@Valid @RequestBody Felino felino) {
        Felino saved = felinoService.save(felino);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/available")
    public List<Felino> getAvailable() {
        return felinoService.getAvailable();
    }

    @GetMapping("/vaccine/{vaccine}")
    public List<Felino> getByVaccine(@PathVariable boolean vaccine) {
        return felinoService.getByVaccine(vaccine);
    }
}