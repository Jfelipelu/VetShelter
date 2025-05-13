package com.veterinaria.veterinaria_api.dto;

import java.util.Map;

public class MetricasDTO {
    private long totalAnimales;
    private long totalAdopciones;
    private long totalAcogidas;
    private Map<String, Long> totalPorEspecie;


    public long getTotalAnimales() {
        return totalAnimales;
    }

    public void setTotalAnimales(long totalAnimales) {
        this.totalAnimales = totalAnimales;
    }

    public long getTotalAdopciones() {
        return totalAdopciones;
    }

    public void setTotalAdopciones(long totalAdopciones) {
        this.totalAdopciones = totalAdopciones;
    }

    public long getTotalAcogidas() {
        return totalAcogidas;
    }

    public void setTotalAcogidas(long totalAcogidas) {
        this.totalAcogidas = totalAcogidas;
    }

    public Map<String, Long> getTotalPorEspecie() {
        return totalPorEspecie;
    }

    public void setTotalPorEspecie(Map<String, Long> totalPorEspecie) {
        this.totalPorEspecie = totalPorEspecie;
    }
}
