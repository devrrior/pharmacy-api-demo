package com.example.pharmacyapidemo.web.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateProductRequest {
    private String title;
    private String description;
    private Float price;
    private String imageURL;
}
