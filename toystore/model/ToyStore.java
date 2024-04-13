package com.example.toystore.toystore.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ToyStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "toyStore", cascade = CascadeType.ALL)
    private List<Toy> toys;

    // Constructors
    public ToyStore() {
    }

    public ToyStore(Long id, String name, String email, List<Toy> toys) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.toys = toys;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }
}
