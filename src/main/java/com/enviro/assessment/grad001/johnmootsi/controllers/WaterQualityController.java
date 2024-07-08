package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.dto.WaterQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.services.WaterQualityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/water-quality")
public class WaterQualityController {

    private final WaterQualityService waterQualityService;

    public WaterQualityController(WaterQualityService waterQualityService) {
        this.waterQualityService = waterQualityService;
    }

    // Get water quality results by id endpoint
    @GetMapping("/results/{id}")
    public ResponseEntity<WaterQualityDTO> getWaterQualityResultsById(@PathVariable Long id) {
        WaterQualityDTO waterQualityDTO = waterQualityService.findWaterQualityById(id);
        return new ResponseEntity<>(waterQualityDTO, HttpStatus.OK);
    }

    // Get water quality results by name endpoint
    @GetMapping("/results/name/{name}")
    public ResponseEntity<List<WaterQualityDTO>> getWaterQualityResultsByName(@PathVariable String name) {
        List<WaterQualityDTO> waterQualityDTO = waterQualityService.findWaterQualityByName(name);
        return new ResponseEntity<>(waterQualityDTO, HttpStatus.OK);
    }

    // Get all water quality results endpoint
    @GetMapping("/results")
    public ResponseEntity<List<WaterQualityDTO>> getWaterQualityResults() {
        List<WaterQualityDTO> waterQualityDTOS = waterQualityService.findAllWaterQuality();
        return new ResponseEntity<>(waterQualityDTOS, HttpStatus.OK);
    }
}
