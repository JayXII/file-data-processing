package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.handlers.ProcessFileResponseHandler;
import com.enviro.assessment.grad001.johnmootsi.dto.*;
import com.enviro.assessment.grad001.johnmootsi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class FileProcessorController {

    @Autowired
    private EnvironmentalDataService environmentalDataService;
    @Autowired
    private AirQualityService airQualityService;
    @Autowired
    private DeforestationRatesService deforestationRatesService;
    @Autowired
    private LandUseService landUseService;
    @Autowired
    private WaterQualityService waterQualityService;
    @Autowired
    ProcessFileResponseHandler response;


    // Temp method 1
    @GetMapping("/hello")
    public String helloWorld() {
        return "Oh hai, world!";
    }

    // Temp method 2
    @GetMapping("/hello/{name}")
    public String helloWorld(@PathVariable String name) {
        return "Oh hai, ".concat(name).concat("!");
    }

    // File upload endpoint
    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProcessFileResponseHandler> processFile(@RequestParam("file") MultipartFile file) {
        String message = environmentalDataService.upload(file);
        response.setMessage(message);
        return ResponseEntity.ok(response);
    }

    // Get Deforestation Rates results by id endpoint
    @GetMapping("/results/deforestation/{id}")
    public ResponseEntity<DeforestationRatesDTO> getDeforestationRatesResultsById(@PathVariable Long id) {
        DeforestationRatesDTO deforestationRatesDTO = deforestationRatesService.findDeforestationRatesById(id);
        return new ResponseEntity<>(deforestationRatesDTO, HttpStatus.OK);
    }

    // Get Deforestation Rates results by name endpoint
    @GetMapping("/results/deforestation/name/{name}")
    public ResponseEntity<List<DeforestationRatesDTO>> getDeforestationRatesResultsByName(@PathVariable String name) {
        List<DeforestationRatesDTO> deforestationRatesDTO = deforestationRatesService.findDeforestationRatesByName(name);
        return new ResponseEntity<>(deforestationRatesDTO, HttpStatus.OK);
    }

    // Get all Deforestation Rates results endpoint
    @GetMapping("/results/deforestation")
    public ResponseEntity<List<DeforestationRatesDTO>> getDeforestationRatesResults() {
        List<DeforestationRatesDTO> deforestationRatesDTOS = deforestationRatesService.findAllDeforestationRates();
        return new ResponseEntity<>(deforestationRatesDTOS, HttpStatus.OK);
    }

    // Get land use results by id endpoint
    @GetMapping("/results/land/{id}")
    public ResponseEntity<LandUseDTO> getLandUseResultsById(@PathVariable Long id) {
        LandUseDTO landUseDTO = landUseService.findLandUseById(id);
        return new ResponseEntity<>(landUseDTO, HttpStatus.OK);
    }

    // Get land use results by name endpoint
    @GetMapping("/results/land/name/{name}")
    public ResponseEntity<List<LandUseDTO>> getLandUseResultsByName(@PathVariable String name) {
        List<LandUseDTO> landUseDTO = landUseService.findLandUseByName(name);
        return new ResponseEntity<>(landUseDTO, HttpStatus.OK);
    }

    // Get all land use results endpoint
    @GetMapping("/results/land")
    public ResponseEntity<List<LandUseDTO>> getLandUseResults() {
        List<LandUseDTO> landUseDTOS = landUseService.findAllLandUse();
        return new ResponseEntity<>(landUseDTOS, HttpStatus.OK);
    }

    // Get water quality results by id endpoint
    @GetMapping("/results/water/{id}")
    public ResponseEntity<WaterQualityDTO> getWaterQualityResultsById(@PathVariable Long id) {
        WaterQualityDTO waterQualityDTO = waterQualityService.findWaterQualityById(id);
        return new ResponseEntity<>(waterQualityDTO, HttpStatus.OK);
    }

    // Get water quality results by name endpoint
    @GetMapping("/results/water/name/{name}")
    public ResponseEntity<List<WaterQualityDTO>> getWaterQualityResultsByName(@PathVariable String name) {
        List<WaterQualityDTO> waterQualityDTO = waterQualityService.findWaterQualityByName(name);
        return new ResponseEntity<>(waterQualityDTO, HttpStatus.OK);
    }

    // Get all water quality results endpoint
    @GetMapping("/results/water")
    public ResponseEntity<List<WaterQualityDTO>> getWaterQualityResults() {
        List<WaterQualityDTO> waterQualityDTOS = waterQualityService.findAllWaterQuality();
        return new ResponseEntity<>(waterQualityDTOS, HttpStatus.OK);
    }

    // Get air quality results by id endpoint
    @GetMapping("/results/air/{id}")
    public ResponseEntity<AirQualityDTO> getAirQualityResultsById(@PathVariable Long id) {
        AirQualityDTO airQualityDTO = airQualityService.findAirQualityById(id);
        return new ResponseEntity<>(airQualityDTO, HttpStatus.OK);
    }

    // Get air quality results by name endpoint
    @GetMapping("/results/air/name/{name}")
    public ResponseEntity<List<AirQualityDTO>> getAirQualityResultsByName(@PathVariable String name) {
        List<AirQualityDTO> airQualityDTO = airQualityService.findAirQualityByName(name);
        return new ResponseEntity<>(airQualityDTO, HttpStatus.OK);
    }

    // Get all air quality results endpoint
    @GetMapping("/results/air")
    public ResponseEntity<List<AirQualityDTO>> getAirQualityResults() {
        List<AirQualityDTO> airQualityDTOS = airQualityService.findAllAirQuality();
        return new ResponseEntity<>(airQualityDTOS, HttpStatus.OK);
    }

}
