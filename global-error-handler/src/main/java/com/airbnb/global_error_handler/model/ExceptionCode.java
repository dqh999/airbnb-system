package com.airbnb.global_error_handler.model;

public interface ExceptionCode {
    Integer getCode();
    String getType();
    String getMessage();
}
