package com.example.pharmacyapidemo.persistance.repositories;

import com.example.pharmacyapidemo.persistance.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
}
