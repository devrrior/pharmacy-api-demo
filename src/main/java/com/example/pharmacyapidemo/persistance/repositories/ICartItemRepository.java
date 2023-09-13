package com.example.pharmacyapidemo.persistance.repositories;

import com.example.pharmacyapidemo.persistance.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, Long> {
}
