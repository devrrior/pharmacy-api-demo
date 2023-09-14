package com.example.pharmacyapidemo.services.impls;

import com.example.pharmacyapidemo.persistance.entities.Cart;
import com.example.pharmacyapidemo.persistance.entities.CartItem;
import com.example.pharmacyapidemo.persistance.repositories.ICartRepository;
import com.example.pharmacyapidemo.services.ICartService;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;
import com.example.pharmacyapidemo.web.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartRepository repository;

    @Override
    public BaseResponse create() {
        Cart cart = new Cart();
        List<CartItem> cartItems = new ArrayList<>();
        cart.setItems(cartItems);

        Cart savedCart = repository.save(cart);

        return BaseResponse.builder()
                .data(savedCart)
                .message("Cart created")
                .success(Boolean.TRUE)
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    @Override
    public BaseResponse get(Long id) {
        Cart cart = findOneAndEnsureExists(id);

        return BaseResponse.builder()
                .data(cart)
                .message("Cart found")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @Override
    public Cart findOneAndEnsureExists(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    }
}
