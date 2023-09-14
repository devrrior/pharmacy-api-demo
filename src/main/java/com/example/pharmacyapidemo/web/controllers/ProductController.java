package com.example.pharmacyapidemo.web.controllers;

import com.example.pharmacyapidemo.services.IProductService;
import com.example.pharmacyapidemo.web.dtos.requests.CreateProductRequest;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateProductRequest request) {
        return service.create(request).apply();
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id) {
        return service.get(id).apply();
    }

    @GetMapping
    public ResponseEntity<BaseResponse> list(@RequestParam(defaultValue = "") String query) {
        return service.list(query).apply();
    }
}
