package com.airbnb.global_error_handler.model;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final String message;
    private final ExceptionCode exceptionCode;

    public AppException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
        this.message = exceptionCode.getMessage();
    }

    public AppException(ExceptionCode exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
        this.message = message;
    }
}
