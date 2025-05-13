package com.veterinaria.veterinaria_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @NotBlank(message = "El tipo de transacción es obligatorio (adopción o acogida)")
    private String type;

    @NotBlank(message = "La fecha es obligatoria")
    private String date;

    @NotBlank(message = "El responsable es obligatorio")
    private String responsible;


    public Transaccion() {}

    public Transaccion(Animal animal, String type, String date, String responsible) {
        this.animal = animal;
        this.type = type;
        this.date = date;
        this.responsible = responsible;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Animal getAnimal() { return animal; }

    public void setAnimal(Animal animal) { this.animal = animal; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getResponsible() { return responsible; }

    public void setResponsible(String responsible) { this.responsible = responsible; }
}