package com.example.pharmacyapidemo.web.dtos.requests;

import lombok.Getter;

@Getter
public class CreateCartItemRequest {
    private Long productId;
    private Long cartId;
    private Integer quantity;
}
