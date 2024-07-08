package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.dto.AirQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.services.AirQualityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/air-quality")
public class AirQualityController {

    private final AirQualityService airQualityService;

    public AirQualityController(AirQualityService airQualityService) {
        this.airQualityService = airQualityService;
    }

    // Get air quality results by id endpoint
    @GetMapping(value = "/results/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAirQualityResultsById(@PathVariable Long id) {
        AirQualityDTO airQualityDTO = airQualityService.findAirQualityById(id);
        if (airQualityDTO == null) {
            String message = "Requested air quality results with id: " + id + ", does not exist";
            return new ResponseEntity<>(message.toCharArray(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(airQualityDTO, HttpStatus.OK);
        }
    }

    // Get air quality results by name endpoint
    @GetMapping("/results/name/{name}")
    public ResponseEntity<List<AirQualityDTO>> getAirQualityResultsByName(@PathVariable String name) {
        List<AirQualityDTO> airQualityDTO = airQualityService.findAirQualityByName(name);
        return new ResponseEntity<>(airQualityDTO, HttpStatus.OK);
    }

    // Get all air quality results endpoint
    @GetMapping("/results")
    public ResponseEntity<List<AirQualityDTO>> getAirQualityResults() {
        List<AirQualityDTO> airQualityDTOS = airQualityService.findAllAirQuality();
        return new ResponseEntity<>(airQualityDTOS, HttpStatus.OK);
    }
}
