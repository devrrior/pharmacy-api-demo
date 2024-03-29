package com.example.pharmacyapidemo.services;

import com.example.pharmacyapidemo.web.dtos.requests.CreateCartItemRequest;
import com.example.pharmacyapidemo.web.dtos.requests.UpdateCartItemRequest;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;

public interface ICartItemService {
    BaseResponse create(CreateCartItemRequest request);
    BaseResponse update(Long id, UpdateCartItemRequest request);
    BaseResponse delete(Long id);
}
