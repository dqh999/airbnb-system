package com.airbnb.global_error_handler.advice;

import com.airbnb.global_error_handler.model.ApiResponse;
import com.airbnb.global_error_handler.model.AppException;
import com.airbnb.global_error_handler.model.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse<?>> handleAppException(AppException e) {
        return handleException(e.getExceptionCode(), e.getMessage());
    }

    private ResponseEntity<ApiResponse<?>> handleException(ExceptionCode e, String message) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("type", e != null ? e.getType() : HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        HttpStatus status = HttpStatus.resolve(e != null ? e.getCode() : HttpStatus.INTERNAL_SERVER_ERROR.value());
        if (status == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        ApiResponse<?> errorResponse = ApiResponse.<Void>build()
                .withCode(status.value())
                .withErrors(errors)
                .withMessage(message != null ? message : e != null ? e.getMessage() : "");
        return ResponseEntity.status(status).body(errorResponse);
    }
}
