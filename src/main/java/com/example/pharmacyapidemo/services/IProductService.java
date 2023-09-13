package com.example.pharmacyapidemo.services;

import com.example.pharmacyapidemo.web.dtos.requests.CreateProductRequest;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;

public interface IProductService {
    BaseResponse create(CreateProductRequest request);
}
