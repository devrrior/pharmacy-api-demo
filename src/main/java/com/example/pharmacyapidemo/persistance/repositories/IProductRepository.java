package com.example.pharmacyapidemo.persistance.repositories;

import com.example.pharmacyapidemo.persistance.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
