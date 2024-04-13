package com.example.toystore.toystore.repository;

import com.example.toystore.toystore.model.ToyStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyStoreRepository extends JpaRepository<ToyStore, Long> {

    // No custom query added for ToyStoreRepository
}
