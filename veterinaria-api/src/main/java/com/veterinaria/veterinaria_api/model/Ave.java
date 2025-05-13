package com.veterinaria.veterinaria_api.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ave extends Animal {

    @NotNull(message = "Especificar si es volador.")
    private Boolean canFly;

    public Ave() {
        super();
    }

    public Ave(String name, String species, String breed, int age, String healthStatus, boolean available, boolean vaccinated, String admissionDate, String transactionDate, boolean canFly) {
        super(name, species, breed, age, healthStatus, available, vaccinated, admissionDate, transactionDate);
        this.canFly = canFly;
    }

    public Boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(Boolean canFly) {
        this.canFly = canFly;
    }
}