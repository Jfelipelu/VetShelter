package com.veterinaria.veterinaria_api.service;

import com.veterinaria.veterinaria_api.model.Reptiles;
import com.veterinaria.veterinaria_api.repository.ReptilesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReptilesService {

    private final ReptilesRepository reptilRepository;

    public ReptilesService(ReptilesRepository reptilRepository) {
        this.reptilRepository = reptilRepository;
    }

    public List<Reptiles> getAll() {
        return reptilRepository.findAll();
    }
    public Reptiles save(Reptiles reptil) {
        return reptilRepository.save(reptil);
    }

    public List<Reptiles> getAvailable() {
        return reptilRepository.findByAvailable(true);
    }

    public List<Reptiles> getByVaccine(boolean vaccine) {
        return reptilRepository.findByVaccine(vaccine);
    }
}
