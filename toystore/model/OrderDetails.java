package com.example.toystore.toystore.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;

    @ElementCollection
    @CollectionTable(name = "order_item", joinColumns = @JoinColumn(name = "order_id"))
    private List<String> orderedItems;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "toy_store_id")
    private ToyStore toyStore;

    // Constructors
    public OrderDetails() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<String> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public ToyStore getToyStore() {
        return toyStore;
    }

    public void setToyStore(ToyStore toyStore) {
        this.toyStore = toyStore;
    }
}
