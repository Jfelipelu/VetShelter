package com.veterinaria.veterinaria_api.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Anfibios extends Animal {

    @NotNull(message = "Campo obligatorio")
    private Boolean aquatic;

    public Anfibios() {
        super();
    }

    public Anfibios(String name, String species, String breed, int age, String healthStatus,
                    boolean available, boolean vaccinated, String admissionDate,
                    String transactionDate, boolean aquatic) {
        super(name, species, breed, age, healthStatus, available, vaccinated, admissionDate, transactionDate);
        this.aquatic = aquatic;
    }

    public Boolean isAquatic() {
        return aquatic;
    }

    public void setAquatic(Boolean aquatic) {
        this.aquatic = aquatic;
    }
}