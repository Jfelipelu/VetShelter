package com.veterinaria.veterinaria_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "La especie es requerida")
    private String species;

    @NotBlank(message = "Raza es requerida")
    private String breed;

    @Min(value = 0, message = "La edad no puede ser negativa")
    private int age;

    @NotBlank(message = "El estado de salud es requerido")
    private String health;

    private boolean available;

    private boolean vaccine;

    @NotBlank(message = "Fecha de admisión es requerida")
    private String admissionDate;

    @NotBlank(message = "La fecha de transacción es obligatoria")
    private String transactionDate;

    public Animal() {
        // Constructor Vacío
    }

    public Animal(String name, String species, String breed, int age, String health,
                  boolean available, boolean vaccine, String admissionDate, String transactionDate) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.health = health;
        this.available = available;
        this.vaccine = vaccine;
        this.admissionDate = admissionDate;
        this.transactionDate = transactionDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getHealth() { return health; }
    public void setHealth(String health) { this.health = health; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public boolean isVaccine() { return vaccine; }
    public void setVaccine(boolean vaccine) { this.vaccine = vaccine; }

    public String getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }

    public String getTransactionDate() { return transactionDate; }
    public void setTransactionDate(String transactionDate) { this.transactionDate = transactionDate; }
}
