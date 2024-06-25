package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.converters.AirQualityDTOAndEntityConverter;
import com.enviro.assessment.grad001.johnmootsi.dto.AirQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.AirQualityEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.AirQualityRepository;
import com.enviro.assessment.grad001.johnmootsi.services.AirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirQualityServiceImplementation implements AirQualityService {
    
    @Autowired
    AirQualityRepository airQualityRepository;

    @Autowired
    AirQualityDTOAndEntityConverter airQualityDTOAndEntityConverter;
    
    @Override
    public AirQualityDTO findAirQualityById(Long id) {
        AirQualityDTO airQualityDTO = null;
        // Find air quality results by id
        Optional<AirQualityEntity> optionalAirQualityEntity = airQualityRepository.findById(id);
        // Convert Entity to DTO if it exists
        if (optionalAirQualityEntity.isPresent()) {
            AirQualityEntity airQualityEntity = optionalAirQualityEntity.get();
            airQualityDTO = airQualityDTOAndEntityConverter.convertToDTO(airQualityEntity);
        }
        // Return processed results
        return airQualityDTO;
    }

    @Override
    public AirQualityDTO findAirQualityByName(String name) {
        // Find air quality results by name
        AirQualityEntity airQualityEntity = airQualityRepository.findByName(name);
        // Convert Entity to DTO
        AirQualityDTO airQualityDTO = airQualityDTOAndEntityConverter.convertToDTO(airQualityEntity);
        // Return processed results
        return airQualityDTO;
    }

    @Override
    public List<AirQualityDTO> findAllAirQuality() {
        // Find all air quality results
        List<AirQualityEntity> airQualityEntities = airQualityRepository.findAll();
        // Convert Entity to DTO by iterating over air quality entity list
        List<AirQualityDTO> airQualityDTOS = new ArrayList<>();

        for (AirQualityEntity airQualityEntity : airQualityEntities) {
            // Convert Entity to DTO
            AirQualityDTO airQualityDTO = airQualityDTOAndEntityConverter.convertToDTO(airQualityEntity);
            // Add to the DTO list
            airQualityDTOS.add(airQualityDTO);
        }
        // Return processed results
        return airQualityDTOS;
    }

    @Override
    public void save(AirQualityDTO airQualityDTO) {
        AirQualityEntity airQualityEntity = airQualityDTOAndEntityConverter.convertToEntity(airQualityDTO);
        airQualityRepository.save(airQualityEntity);
    }
}
