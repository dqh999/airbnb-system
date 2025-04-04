package com.airbnb.listing_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.airbnb.listing_service",
        "com.dqhdev.global_error_handler"
})
public class ListingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListingServiceApplication.class, args);
    }

}
