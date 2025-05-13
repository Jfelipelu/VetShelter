package com.veterinaria.veterinaria_api.service;

import com.veterinaria.veterinaria_api.model.Anfibios;
import com.veterinaria.veterinaria_api.repository.AnfibiosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnfibiosService {

    private final AnfibiosRepository anfibioRepository;

    public AnfibiosService(AnfibiosRepository anfibioRepository) {
        this.anfibioRepository = anfibioRepository;
    }

    public List<Anfibios> getAll() {
        return anfibioRepository.findAll();
    }

    public Anfibios save(Anfibios anfibio) {
        return anfibioRepository.save(anfibio);
    }

    public List<Anfibios> getAvailable() {
        return anfibioRepository.findByAvailable(true);
    }

    public List<Anfibios> getByVaccine(boolean vaccine) {
        return anfibioRepository.findByVaccine(vaccine);
    }

}

