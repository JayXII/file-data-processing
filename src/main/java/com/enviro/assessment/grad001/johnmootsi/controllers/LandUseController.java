package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.dto.LandUseDTO;
import com.enviro.assessment.grad001.johnmootsi.services.LandUseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/land-use")
public class LandUseController {

    private final LandUseService landUseService;

    public LandUseController(LandUseService landUseService) {
        this.landUseService = landUseService;
    }

    // Get land use results by id endpoint
    @GetMapping("/results/{id}")
    public ResponseEntity<LandUseDTO> getLandUseResultsById(@PathVariable Long id) {
        LandUseDTO landUseDTO = landUseService.findLandUseById(id);
        return new ResponseEntity<>(landUseDTO, HttpStatus.OK);
    }

    // Get land use results by name endpoint
    @GetMapping("/results/name/{name}")
    public ResponseEntity<List<LandUseDTO>> getLandUseResultsByName(@PathVariable String name) {
        List<LandUseDTO> landUseDTO = landUseService.findLandUseByName(name);
        return new ResponseEntity<>(landUseDTO, HttpStatus.OK);
    }

    // Get all land use results endpoint
    @GetMapping("/results")
    public ResponseEntity<List<LandUseDTO>> getLandUseResults() {
        List<LandUseDTO> landUseDTOS = landUseService.findAllLandUse();
        return new ResponseEntity<>(landUseDTOS, HttpStatus.OK);
    }
}
