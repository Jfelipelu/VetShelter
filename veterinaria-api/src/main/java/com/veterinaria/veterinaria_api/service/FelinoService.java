package com.veterinaria.veterinaria_api.service;

import com.veterinaria.veterinaria_api.model.Felino;
import com.veterinaria.veterinaria_api.repository.FelinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FelinoService {

    private final FelinoRepository felinoRepository;

    public FelinoService(FelinoRepository felinoRepository) {
        this.felinoRepository = felinoRepository;
    }

    public List<Felino> getAll() {
        return felinoRepository.findAll();
    }

    public Felino save(Felino felino) {
        return felinoRepository.save(felino);
    }

    public List<Felino> getAvailable() {
        return felinoRepository.findByAvailable(true);
    }

    public List<Felino> getByVaccine(boolean vaccine) {
        return felinoRepository.findByVaccine(vaccine);
    }
}
