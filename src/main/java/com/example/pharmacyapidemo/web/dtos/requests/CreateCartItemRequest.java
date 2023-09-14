package com.example.pharmacyapidemo.web.dtos.requests;

import lombok.Getter;

@Getter
public class CreateCartItemRequest {
    private Long product_id;
    private Long cart_id;
    private Integer quantity;
}
