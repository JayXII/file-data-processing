package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.dto.ProcessedResultsDTO;
import com.enviro.assessment.grad001.johnmootsi.services.EnvironmentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1")
public class FileProcessorController {

    @Autowired
    private EnvironmentalDataService environmentalDataService;

    // Test method
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, world!";
    }

    // File upload endpoint
    @PostMapping("/upload")
    public ResponseEntity<String> processFile(@RequestParam("file") MultipartFile file) {
        environmentalDataService.upload(file);
        return ResponseEntity.ok("Hello, ");
    }

    // Get results by id endpoint
    @GetMapping("/results/{id}")
    public ResponseEntity<String> getProcessedResultsById(@PathVariable Long id) {
        return ResponseEntity.ok("Hello, ");
    }

    // Get results by name endpoint
    @GetMapping("/results/{name}")
    public ResponseEntity<ProcessedResultsDTO> getProcessedResultsByName(@PathVariable String name) {
        ProcessedResultsDTO processedResultsDTO = environmentalDataService.getProcessedResultsByName(name);
        ResponseEntity<ProcessedResultsDTO> processedResults = new ResponseEntity<>(processedResultsDTO, HttpStatus.OK);
        return processedResults;
    }

    // Get all results
    @GetMapping("/results")
    public ResponseEntity<String> getAllProcessedResults() {
        return ResponseEntity.ok("Hello, ");
    }
}
