package com.example.pharmacyapidemo.web.advices;

import com.example.pharmacyapidemo.web.dtos.responses.BaseResponse;
import com.example.pharmacyapidemo.web.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BaseResponse> handleObjectNotFoundException(ResourceNotFoundException exception) {
        return BaseResponse.builder()
                .message(exception.getLocalizedMessage())
                .status(HttpStatus.NOT_FOUND)
                .statusCode(404)
                .success(false)
                .build()
                .apply();
    }
}
