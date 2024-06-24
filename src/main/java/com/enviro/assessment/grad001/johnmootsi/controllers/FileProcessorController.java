package com.enviro.assessment.grad001.johnmootsi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1")
public class FileProcessorController {

    // Test method
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, world!";
    }

    // File upload endpoint
    @PostMapping("/upload")
    public ResponseEntity<String> processFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok("Hello, ");
    }

    // Get results with id endpoint
    @GetMapping("/results/{id}")
    public ResponseEntity<String> getProcessedResultsById(@PathVariable Long id) {
        return ResponseEntity.ok("Hello, ");
    }

    // Get all results
    @GetMapping("/results")
    public ResponseEntity<String> getAllProcessedResults() {
        return ResponseEntity.ok("Hello, ");
    }
}
