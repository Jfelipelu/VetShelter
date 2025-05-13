package com.veterinaria.veterinaria_api.controller;

import com.veterinaria.veterinaria_api.model.Canino;
import com.veterinaria.veterinaria_api.service.CaninoService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caninos")
@CrossOrigin(origins = "*")
public class CaninoController {

    private final CaninoService caninoService;

    public CaninoController(CaninoService caninoService) {
        this.caninoService = caninoService;
    }

    @GetMapping
    public List<Canino> getAll() {
        return caninoService.getAll();
    }

    @PostMapping
    public ResponseEntity<Canino> create(@Valid @RequestBody Canino canino) {
        Canino saved = caninoService.save(canino);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/available")
    public List<Canino> getAvailable() {
        return caninoService.getAvailable();
    }

    @GetMapping("/vaccine/{vaccine}")
    public List<Canino> getByVaccine(@PathVariable boolean vaccine) {
        return caninoService.getByVaccine(vaccine);
    }
}