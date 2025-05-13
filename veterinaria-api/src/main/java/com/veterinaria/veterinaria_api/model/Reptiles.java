package com.veterinaria.veterinaria_api.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;

@Entity
public class Reptiles extends Animal {
    
    @NotNull(message = "Se debe especificar si es venenoso.")
    private boolean venomous;

    @NotNull(message = "Debe incluir hábitat.")
    @Size(min = 3, max = 100, message = "Máximo 100 caracteres.")
    private String habitat;

    public Reptiles() {
        super();
    }

    public Reptiles(String name, String species, String breed, int age, String healthStatus, boolean available, boolean vaccinated, String admissionDate, String transactionDate, boolean venomous, String habitat) {
        super(name, species, breed, age, healthStatus, available, vaccinated, admissionDate, transactionDate);
        this.venomous = venomous;
        this.habitat = habitat;
    }

    public boolean isVenomous() {
        return venomous;
    }

    public void setVenomous(boolean venomous) {
        this.venomous = venomous;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}