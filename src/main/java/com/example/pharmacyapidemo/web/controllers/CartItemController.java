package com.example.pharmacyapidemo.web.controllers;

import com.example.pharmacyapidemo.services.ICartItemService;
import com.example.pharmacyapidemo.web.dtos.requests.CreateCartItemRequest;
import com.example.pharmacyapidemo.web.dtos.requests.UpdateCartItemRequest;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart-item")
public class CartItemController {

    @Autowired
    private ICartItemService service;

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateCartItemRequest request) {
        return service.create(request).apply();
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> put(@PathVariable Long id, @RequestBody UpdateCartItemRequest request) {
        return service.update(id, request).apply();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        return service.delete(id).apply();
    }
}
