package com.ravi.springboot.project.controller;

import com.ravi.springboot.project.entity.Department;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acts")
public class AppController {

    @Value("${welcome.message}")
    private String welcomeMsg;
    @GetMapping("/")
    public String getMethod() {
        return welcomeMsg;
    }


}
