package com.example.pharmacyapidemo.web.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Builder @Getter
public class BaseResponse {

    private HttpStatus status;

    private Integer statusCode;

    private String message;

    private Boolean success;

    private Object data;

    public ResponseEntity<BaseResponse> apply() {
        return new ResponseEntity<>(this, status);
    }
}
