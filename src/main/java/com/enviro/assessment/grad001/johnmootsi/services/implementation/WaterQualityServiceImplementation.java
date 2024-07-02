package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.converters.WaterQualityDTOAndEntityConverter;
import com.enviro.assessment.grad001.johnmootsi.dto.WaterQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.WaterQualityEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.WaterQualityRepository;
import com.enviro.assessment.grad001.johnmootsi.services.WaterQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WaterQualityServiceImplementation implements WaterQualityService {

    @Autowired
    private WaterQualityRepository waterQualityRepository;

    @Autowired
    private WaterQualityDTOAndEntityConverter waterQualityDTOAndEntityConverter;


    @Override
    public WaterQualityDTO findWaterQualityById(Long id) {
        WaterQualityDTO waterQualityDTO = null;
        // Find water quality results by id
        Optional<WaterQualityEntity> optionalWaterQualityEntity = waterQualityRepository.findById(id);
        // Convert Entity to DTO if it exists
        if (optionalWaterQualityEntity.isPresent()) {
            WaterQualityEntity waterQualityEntity = optionalWaterQualityEntity.get();
            waterQualityDTO = waterQualityDTOAndEntityConverter.convertToDTO(waterQualityEntity);
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
            WaterQualityDTO waterQualityDTO = waterQualityDTOAndEntityConverter.convertToDTO(waterQualityEntity);
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
            WaterQualityDTO waterQualityDTO = waterQualityDTOAndEntityConverter.convertToDTO(waterQualityEntity);
            // Add to the DTO list
            waterQualityDTOS.add(waterQualityDTO);
        }
        // Return processed results
        return waterQualityDTOS;
    }

    @Override
    public void save(WaterQualityDTO waterQualityDTO) {
        WaterQualityEntity waterQualityEntity = waterQualityDTOAndEntityConverter.convertToEntity(waterQualityDTO);
        waterQualityRepository.save(waterQualityEntity);
    }
}
