package com.example.pharmacyapidemo.persistance.repositories;

import com.example.pharmacyapidemo.persistance.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE UPPER(title) LIKE UPPER(CONCAT('%', ?1, '%'))", nativeQuery = true)
    List<Product> findAllByTitleContainsIgnoreCase(String query);
}
