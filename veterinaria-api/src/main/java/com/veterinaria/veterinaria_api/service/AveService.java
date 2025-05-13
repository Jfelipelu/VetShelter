package com.veterinaria.veterinaria_api.service;

import com.veterinaria.veterinaria_api.model.Ave;
import com.veterinaria.veterinaria_api.repository.AveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AveService {

    private final AveRepository aveRepository;

    public AveService(AveRepository aveRepository) {
        this.aveRepository = aveRepository;
    }

    public List<Ave> getAll() {
        return aveRepository.findAll();
    }

    public Ave save(Ave ave) {
        return aveRepository.save(ave);
    }

    public List<Ave> getAvailable() {
        return aveRepository.findByAvailable(true);
    }

    public List<Ave> getByVaccine(boolean vaccine) {
        return aveRepository.findByVaccine(vaccine);
    }
}
