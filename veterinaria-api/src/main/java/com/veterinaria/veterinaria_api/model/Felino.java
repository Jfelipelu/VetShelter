package com.veterinaria.veterinaria_api.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;

@Entity
public class Felino extends Animal {
    
    @NotNull(message = "Campo requerido")
    @Size(min = 5, max = 12, message = "Mínimo entre 5 y 12 caracteres.")
    private String furLength;

    public Felino() {
        super();
    }

    public Felino(String name, String species, String breed, int age, String healthStatus, boolean available, boolean vaccinated, String admissionDate, String transactionDate, String furLength) {
        super(name, species, breed, age, healthStatus, available, vaccinated, admissionDate, transactionDate);
        this.furLength = furLength;
    }

    public String getFurLength() {
        return furLength;
    }

    public void setFurLength(String furLength) {
        this.furLength = furLength;
    }
}