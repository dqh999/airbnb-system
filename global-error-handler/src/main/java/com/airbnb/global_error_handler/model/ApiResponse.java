package com.airbnb.global_error_handler.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ApiResponse<T> {
    @JsonIgnore
    private HttpStatus httpStatus;
    @JsonIgnore
    private HttpHeaders headers;
    private int code;
    private Boolean isSuccess;
    private String message;
    private T data;
    private Map<String, Object> errors;
    private Date timestamp;

    public ApiResponse() {
        httpStatus = HttpStatus.OK;
        code = 200;
        isSuccess = true;
        errors = new HashMap<>();
        timestamp = new Date();
    }

    public static <T> ApiResponse<T> build() {
        return new ApiResponse<>();
    }

    public ApiResponse<T> withCode(int code) {
        this.code = code;
        this.isSuccess = code == 200;
        return this;
    }

    public ApiResponse<T> withData(T data) {
        this.data = data;
        return this;
    }

    public ApiResponse<T> withHttpHeaders(HttpHeaders headers) {
        this.headers = headers;
        return this;
    }

    public ApiResponse<T> withMessage(String message) {
        this.message = message;
        return this;
    }

    public ApiResponse<T> withErrors(Map<String, Object> errors) {
        this.errors = errors;
        this.isSuccess = errors == null || errors.isEmpty();
        return this;
    }

    public ResponseEntity<ApiResponse<T>> toEntity() {
        return ResponseEntity.status(httpStatus != null ? httpStatus : HttpStatus.OK)
                .headers(headers != null ? headers : new HttpHeaders())
                .body(this);
    }
}
