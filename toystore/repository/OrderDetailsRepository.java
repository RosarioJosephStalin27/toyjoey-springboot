package com.example.toystore.toystore.repository;

import com.example.toystore.toystore.model.OrderDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    @Query("SELECT o FROM OrderDetails o WHERE o.customerName = ?1")
    List<OrderDetails> findByCustomerName(String customerName);
}
