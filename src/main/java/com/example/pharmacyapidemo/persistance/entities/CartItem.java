package com.example.pharmacyapidemo.persistance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_items")
@Getter @Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
