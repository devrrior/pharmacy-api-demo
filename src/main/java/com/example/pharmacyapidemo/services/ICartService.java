package com.example.pharmacyapidemo.services;

import com.example.pharmacyapidemo.persistance.entities.Cart;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;

public interface ICartService {
    BaseResponse create();
    Cart findOneAndEnsureExists(Long id);
}
