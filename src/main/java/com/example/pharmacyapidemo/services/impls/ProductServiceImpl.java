package com.example.pharmacyapidemo.services.impls;

import com.example.pharmacyapidemo.persistance.entities.Product;
import com.example.pharmacyapidemo.persistance.repositories.IProductRepository;
import com.example.pharmacyapidemo.services.IProductService;
import com.example.pharmacyapidemo.web.dtos.requests.CreateProductRequest;
import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;
import com.example.pharmacyapidemo.web.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public BaseResponse get(Long id) {
        Product product = findOneAndEnsureExists(id);

        return BaseResponse.builder()
                .data(product)
                .message("Product found")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @Override
    public BaseResponse list(String query) {
        List<Product> products;

        if (query.length() > 0) {
            products = repository.findAllByTitleContainsIgnoreCase(query);
        } else {
            products = repository.findAll();
        }

        return BaseResponse.builder()
                .data(products)
                .message("Products found")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @Override
    public Product findOneAndEnsureExists(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
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
