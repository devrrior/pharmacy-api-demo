package com.example.pharmacyapidemo.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Float price;

    private String imageURL;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;
}
