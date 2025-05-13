package com.veterinaria.veterinaria_api.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Canino extends Animal {

    @NotNull(message = "Especificar si está entrenado")
    private Boolean trained;

    public Canino() {
        super();
    }

    public Canino(String name, String species, String breed, int age, String health, boolean available, boolean vaccine, String admissionDate, boolean trained, String transactionDate) {
        super(name, species, breed, age, health, available, vaccine, admissionDate, transactionDate);
        this.trained = trained;
    }

    public Boolean isTrained() {
        return trained;
    }

    public void setTrained(Boolean trained) {
        this.trained = trained;
    }
}