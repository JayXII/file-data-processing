package com.enviro.assessment.grad001.johnmootsi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FileProcessorController {

    // Test method
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, world!";
    }
}
