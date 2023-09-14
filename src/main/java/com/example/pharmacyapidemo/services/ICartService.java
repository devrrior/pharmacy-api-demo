package com.example.pharmacyapidemo.services;

import com.example.pharmacyapidemo.persistance.entities.Cart;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;

public interface ICartService {
    BaseResponse create();
    BaseResponse get(Long id);
    Cart findOneAndEnsureExists(Long id);
}
