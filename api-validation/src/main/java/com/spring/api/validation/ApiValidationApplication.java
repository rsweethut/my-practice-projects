package com.spring.api.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.spring.api.validation.controller,com.spring.api.validation.service," +
  //      "com.spring.api.validation.repository,com.spring.api.validation.dto,com.spring.api.validation.entity")
public class ApiValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.spring.api.validation.ApiValidationApplication.class, args);
    }

}

