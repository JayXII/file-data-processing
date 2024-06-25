package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.converters.AirQualityDTOAndEntityConverter;
import com.enviro.assessment.grad001.johnmootsi.dto.*;
import com.enviro.assessment.grad001.johnmootsi.entities.AirQualityEntity;
import com.enviro.assessment.grad001.johnmootsi.entities.DeforestationRatesEntity;
import com.enviro.assessment.grad001.johnmootsi.entities.LandUseEntity;
import com.enviro.assessment.grad001.johnmootsi.entities.WaterQualityEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.*;
import com.enviro.assessment.grad001.johnmootsi.services.EnvironmentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EnvironmentalDataServiceImplementation implements EnvironmentalDataService {

    @Autowired
    private EnvironmentalDataRepository environmentalDataRepository;
    @Autowired
    private AirQualityRepository airQualityRepository;
    @Autowired
    private DeforestationRatesRepository deforestationRatesRepository;
    @Autowired
    private LandUseRepository landUseRepository;
    @Autowired
    private WaterQualityRepository waterQualityRepository;

    @Override
    public String upload(MultipartFile file) {
        return "";
    }

    @Override
    public ProcessedResultsDTO getProcessedResultsById(Long id) {
        return null;
    }

    @Override
    public ProcessedResultsDTO getProcessedResultsByName(String name) {

        ProcessedResultsDTO processedResultsDTO = null;
//
//        switch (name.toLowerCase().strip()) {
//            case "air":
//                AirQualityDTOAndEntityConverter airQualityDTOAndEntityConverter = new AirQualityDTOAndEntityConverter();
//                // Find air quality results by name
//                AirQualityEntity airQualityEntity = airQualityRepository.findByName(name);
//                // Convert Entity to DTO
//                AirQualityDTO airQualityDTO = airQualityEntityToDTOConverter.convertAirQualityEntityToDTO(airQualityEntity);
//                // Return processed results
//                processedResultsDTO = airQualityDTO;
//                break;
//            case "deforestation":
//                DeforestationRatesEntityToDTOConverter deforestationRatesEntityToDTOConverter = new DeforestationRatesEntityToDTOConverter();
//                // Find deforestation rates results by name
//                DeforestationRatesEntity deforestationRatesEntity = deforestationRatesRepository.findByName(name);
//                // Convert Entity to DTO
//                DeforestationRatesDTO deforestationRatesDTO = deforestationRatesEntityToDTOConverter.convertDeforestationEntityToDTO(deforestationRatesEntity);
//                // Return processed results
//                processedResultsDTO = deforestationRatesDTO;
//                break;
//            case "land":
//                LandUseEntityToDTOConverter landUseEntityToDTOConverter = new LandUseEntityToDTOConverter();
//                // Find land use results by name
//                LandUseEntity landUseEntity = landUseRepository.findByName(name);
//                // Convert Entity to DTO
//                LandUseDTO landUseDTO = landUseEntityToDTOConverter.convertLandUseEntityToDTO(landUseEntity);
//                // Return processed results
//                processedResultsDTO = landUseDTO;
//                break;
//            case "water":
//                WaterQualityEntityToDTOConverter waterQualityEntityToDTOConverter = new WaterQualityEntityToDTOConverter();
//                // Find water quality results by name
//                WaterQualityEntity waterQualityEntity = waterQualityRepository.findByName(name);
//                // Convert Entity to DTO
//                WaterQualityDTO waterQualityDTO = waterQualityEntityToDTOConverter.convertWaterQualityEntityToDTO(waterQualityEntity);
//                // Return processed results
//                processedResultsDTO = waterQualityDTO;
//                break;
//        }

        return processedResultsDTO;
    }

    @Override
    public List<ProcessedResultsDTO> getAllProcessedResults() {
        return List.of();
    }
}
