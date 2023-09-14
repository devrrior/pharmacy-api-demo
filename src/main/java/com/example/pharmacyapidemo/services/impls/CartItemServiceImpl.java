package com.example.pharmacyapidemo.services.impls;

import com.example.pharmacyapidemo.persistance.entities.Cart;
import com.example.pharmacyapidemo.persistance.entities.CartItem;
import com.example.pharmacyapidemo.persistance.entities.Product;
import com.example.pharmacyapidemo.persistance.repositories.ICartItemRepository;
import com.example.pharmacyapidemo.services.ICartItemService;
import com.example.pharmacyapidemo.services.ICartService;
import com.example.pharmacyapidemo.services.IProductService;
import com.example.pharmacyapidemo.web.dtos.requests.CreateCartItemRequest;
import com.example.pharmacyapidemo.web.dtos.requests.UpdateCartItemRequest;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;
import com.example.pharmacyapidemo.web.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements ICartItemService {
    @Autowired
    private ICartItemRepository repository;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICartService cartService;

    @Override
    public BaseResponse create(CreateCartItemRequest request) {
        Product product = productService.findOneAndEnsureExists(request.getProductId());
        Cart cart = cartService.findOneAndEnsureExists(request.getCartId());

        CartItem cartItem = repository.save(from(request, product, cart));

        return BaseResponse.builder()
                .data(cartItem)
                .message("Cart item created")
                .success(Boolean.TRUE)
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    @Override
    public BaseResponse update(Long id, UpdateCartItemRequest request) {
        CartItem cartItem = findOneAndEnsureExists(id);

        cartItem.setQuantity(request.getQuantity());

        CartItem updatedCartItem = repository.save(cartItem);

        return BaseResponse.builder()
                .data(updatedCartItem)
                .message("CartItem updated")
                .success(Boolean.TRUE)
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    private CartItem from(CreateCartItemRequest request, Product product, Cart cart) {
        CartItem cartItem = new CartItem();

        cartItem.setQuantity(request.getQuantity());
        cartItem.setProduct(product);
        cartItem.setCart(cart);

        return cartItem;
    }

    private CartItem findOneAndEnsureExists(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CartItem not found"));
    }
}
