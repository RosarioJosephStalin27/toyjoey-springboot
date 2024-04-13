package com.example.toystore.toystore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "toy_store_id")
    private ToyStore toyStore;

    // Constructors
    public Toy() {
    }

    public Toy(Long id, String name, double price, ToyStore toyStore) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.toyStore = toyStore;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ToyStore getToyStore() {
        return toyStore;
    }

    public void setToyStore(ToyStore toyStore) {
        this.toyStore = toyStore;
    }
}
