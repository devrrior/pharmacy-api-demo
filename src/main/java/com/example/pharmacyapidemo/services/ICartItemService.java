package com.example.pharmacyapidemo.services;

import com.example.pharmacyapidemo.web.dtos.requests.CreateCartItemRequest;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;

public interface ICartItemService {
    BaseResponse create(CreateCartItemRequest request);
}
