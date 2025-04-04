package com.airbnb.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.airbnb.user_service",
                "com.dqhdev.global_error_handler"
})

public class UserServiceApplication {
    public static void main(String[] args)
	{
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
