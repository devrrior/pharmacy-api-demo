package com.example.pharmacyapidemo.services.impls;

import com.example.pharmacyapidemo.persistance.entities.Cart;
import com.example.pharmacyapidemo.persistance.repositories.ICartRepository;
import com.example.pharmacyapidemo.services.ICartService;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartRepository repository;

    @Override
    public BaseResponse create() {
        Cart cart = repository.save(new Cart());

        return BaseResponse.builder()
                .data(cart)
                .message("Cart created")
                .success(Boolean.TRUE)
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }
}
