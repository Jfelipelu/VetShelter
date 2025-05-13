package com.veterinaria.veterinaria_api.controller;

import com.veterinaria.veterinaria_api.model.Ave;
import com.veterinaria.veterinaria_api.service.AveService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aves")
@CrossOrigin(origins = "*")
public class AveController {

    private final AveService aveService;

    public AveController(AveService aveService) {
        this.aveService = aveService;
    }

    @GetMapping
    public List<Ave> getAll() {
        return aveService.getAll();
    }

    @PostMapping
    public ResponseEntity<Ave> create(@Valid @RequestBody Ave ave) {
        Ave saved = aveService.save(ave);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/available")
    public List<Ave> getAvailable() {
        return aveService.getAvailable();
    }

    @GetMapping("/vaccine/{vaccine}")
    public List<Ave> getByVaccine(@PathVariable boolean vaccine) {
        return aveService.getByVaccine(vaccine);
    }
}