package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.dto.DeforestationRatesDTO;
import com.enviro.assessment.grad001.johnmootsi.services.DeforestationRatesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deforestation-rates")
public class DeforestationRatesController {

    private final DeforestationRatesService deforestationRatesService;

    public DeforestationRatesController(DeforestationRatesService deforestationRatesService) {
        this.deforestationRatesService = deforestationRatesService;
    }

    // Get Deforestation Rates results by id endpoint
    @GetMapping("/results/{id}")
    public ResponseEntity<DeforestationRatesDTO> getDeforestationRatesResultsById(@PathVariable Long id) {
        DeforestationRatesDTO deforestationRatesDTO = deforestationRatesService.findDeforestationRatesById(id);
        return new ResponseEntity<>(deforestationRatesDTO, HttpStatus.OK);
    }

    // Get Deforestation Rates results by name endpoint
    @GetMapping("/results/name/{name}")
    public ResponseEntity<List<DeforestationRatesDTO>> getDeforestationRatesResultsByName(@PathVariable String name) {
        List<DeforestationRatesDTO> deforestationRatesDTO = deforestationRatesService.findDeforestationRatesByName(name);
        return new ResponseEntity<>(deforestationRatesDTO, HttpStatus.OK);
    }

    // Get all Deforestation Rates results endpoint
    @GetMapping("/results")
    public ResponseEntity<List<DeforestationRatesDTO>> getDeforestationRatesResults() {
        List<DeforestationRatesDTO> deforestationRatesDTOS = deforestationRatesService.findAllDeforestationRates();
        return new ResponseEntity<>(deforestationRatesDTOS, HttpStatus.OK);
    }
}
