package com.example.pharmacyapidemo.web.controllers;

import com.example.pharmacyapidemo.services.ICartService;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private ICartService service;

    @PostMapping
    public ResponseEntity<BaseResponse> create() {
        return service.create().apply();
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id) {
        return service.get(id).apply();
    }
}
