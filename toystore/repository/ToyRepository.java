package com.example.toystore.toystore.repository;

import com.example.toystore.toystore.model.Toy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ToyRepository extends JpaRepository<Toy, Long> {

    @Query("SELECT t FROM Toy t WHERE t.name LIKE %?1%")
    List<Toy> findByNameContaining(String keyword);
}
