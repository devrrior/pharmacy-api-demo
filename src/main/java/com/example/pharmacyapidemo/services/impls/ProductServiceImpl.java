package com.example.pharmacyapidemo.services.impls;

import com.example.pharmacyapidemo.persistance.entities.Product;
import com.example.pharmacyapidemo.persistance.repositories.IProductRepository;
import com.example.pharmacyapidemo.services.IProductService;
import com.example.pharmacyapidemo.web.dtos.requests.CreateProductRequest;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public BaseResponse create(CreateProductRequest request) {
        Product product = repository.save(from(request));

        return BaseResponse.builder()
                .data(product)
                .message("Product created!")
                .success(true)
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    private Product from(CreateProductRequest request) {
        Product product = new Product();

        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setImageURL(request.getImageURL());

        return product;
    }
}
