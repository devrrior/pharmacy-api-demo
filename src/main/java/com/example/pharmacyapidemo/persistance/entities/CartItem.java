package com.example.pharmacyapidemo.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "cart_items")
@Getter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
