package com.veterinaria.veterinaria_api.service;

import com.veterinaria.veterinaria_api.model.Canino;
import com.veterinaria.veterinaria_api.repository.CaninoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaninoService {

    private final CaninoRepository caninoRepository;

    public CaninoService(CaninoRepository caninoRepository) {
        this.caninoRepository = caninoRepository;
    }

    public List<Canino> getAll() {
        return caninoRepository.findAll();
    }

    public Canino save(Canino canino) {
        return caninoRepository.save(canino);
    }

    public List<Canino> getAvailable() {
        return caninoRepository.findByAvailable(true);
    }

    public List<Canino> getByVaccine(boolean vaccine) {
        return caninoRepository.findByVaccine(vaccine);
    }
}
