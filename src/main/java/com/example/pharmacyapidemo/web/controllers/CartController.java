package com.example.pharmacyapidemo.web.controllers;

import com.example.pharmacyapidemo.services.ICartService;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private ICartService service;

    @PostMapping
    public ResponseEntity<BaseResponse> create() {
        return service.create().apply();
    }
}
