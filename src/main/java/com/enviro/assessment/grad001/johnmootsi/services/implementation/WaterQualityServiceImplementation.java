package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.utility.converters.WaterQualityDTOAndEntityConverter;
import com.enviro.assessment.grad001.johnmootsi.dto.WaterQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.WaterQualityEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.WaterQualityRepository;
import com.enviro.assessment.grad001.johnmootsi.services.WaterQualityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WaterQualityServiceImplementation implements WaterQualityService {

    private final WaterQualityRepository waterQualityRepository;

    public WaterQualityServiceImplementation(WaterQualityRepository waterQualityRepository) {
        this.waterQualityRepository = waterQualityRepository;
    }

    @Override
    public WaterQualityDTO findWaterQualityById(Long id) {
        WaterQualityDTO waterQualityDTO = null;
        // Find water quality results by id
        Optional<WaterQualityEntity> optionalWaterQualityEntity = waterQualityRepository.findById(id);
        // Convert Entity to DTO if it exists
        if (optionalWaterQualityEntity.isPresent()) {
            WaterQualityEntity waterQualityEntity = optionalWaterQualityEntity.get();
            waterQualityDTO = WaterQualityDTOAndEntityConverter.convertToDTO(waterQualityEntity);
        }
        // Return processed results
        return waterQualityDTO;
    }

    @Override
    public List<WaterQualityDTO> findWaterQualityByName(String name) {
        // Find water quality results by name
        List<WaterQualityEntity> waterQualityEntities = waterQualityRepository.findByNameContainingIgnoreCase(name);
        // Convert Entity to DTO by iterating over water quality entity list
        List<WaterQualityDTO> waterQualityDTOS = new ArrayList<>();

        for (WaterQualityEntity waterQualityEntity : waterQualityEntities) {
            // Convert Entity to DTO
            WaterQualityDTO waterQualityDTO = WaterQualityDTOAndEntityConverter.convertToDTO(waterQualityEntity);
            // Add to the DTO list
            waterQualityDTOS.add(waterQualityDTO);
        }
        // Return processed results
        return waterQualityDTOS;
    }

    @Override
    public List<WaterQualityDTO> findAllWaterQuality() {
        // Find all water quality results
        List<WaterQualityEntity> waterQualityEntities = waterQualityRepository.findAll();
        // Convert Entity to DTO by iterating over water quality entity list
        List<WaterQualityDTO> waterQualityDTOS = new ArrayList<>();

        for (WaterQualityEntity waterQualityEntity : waterQualityEntities) {
            // Convert Entity to DTO
            WaterQualityDTO waterQualityDTO = WaterQualityDTOAndEntityConverter.convertToDTO(waterQualityEntity);
            // Add to the DTO list
            waterQualityDTOS.add(waterQualityDTO);
        }
        // Return processed results
        return waterQualityDTOS;
    }

    @Override
    public String save(WaterQualityDTO waterQualityDTO) {
        WaterQualityEntity waterQualityEntity = WaterQualityDTOAndEntityConverter.convertToEntity(waterQualityDTO);
        waterQualityRepository.save(waterQualityEntity);
        return "Success";
    }
}
