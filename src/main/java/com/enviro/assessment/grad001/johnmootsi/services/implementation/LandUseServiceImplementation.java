package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.dto.LandUseDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.LandUseEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.LandUseRepository;
import com.enviro.assessment.grad001.johnmootsi.services.LandUseService;
import com.enviro.assessment.grad001.johnmootsi.utility.converters.LandUseDTOAndEntityConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LandUseServiceImplementation implements LandUseService {

    private final LandUseRepository landUseRepository;

    public LandUseServiceImplementation(LandUseRepository landUseRepository) {
        this.landUseRepository = landUseRepository;
    }

    @Override
    public LandUseDTO findLandUseById(Long id) {
        LandUseDTO landUseDTO = null;
        // Find land use results by id
        Optional<LandUseEntity> optionalLandUseEntity = landUseRepository.findById(id);
        // Convert Entity to DTO if it exists
        if (optionalLandUseEntity.isPresent()) {
            LandUseEntity landUseEntity = optionalLandUseEntity.get();
            landUseDTO = LandUseDTOAndEntityConverter.convertToDTO(landUseEntity);
        }
        // Return processed results
        return landUseDTO;
    }

    @Override
    public List<LandUseDTO> findLandUseByName(String name) {
        // Find land use results by name
        List<LandUseEntity> landUseEntities = landUseRepository.findByNameContainingIgnoreCase(name);
        // Convert Entity to DTO by iterating over land use entity list
        List<LandUseDTO> landUseDTOS = new ArrayList<>();

        for (LandUseEntity landUseEntity : landUseEntities) {
            // Convert Entity to DTO
            LandUseDTO landUseDTO = LandUseDTOAndEntityConverter.convertToDTO(landUseEntity);
            // Add to the DTO list
            landUseDTOS.add(landUseDTO);
        }
        // Return processed results
        return landUseDTOS;
    }

    @Override
    public List<LandUseDTO> findAllLandUse() {
        // Find all land use results
        List<LandUseEntity> landUseEntities = landUseRepository.findAll();
        // Convert Entity to DTO by iterating over land use entity list
        List<LandUseDTO> landUseDTOS = new ArrayList<>();

        for (LandUseEntity landUseEntity : landUseEntities) {
            // Convert Entity to DTO
            LandUseDTO landUseDTO = LandUseDTOAndEntityConverter.convertToDTO(landUseEntity);
            // Add to the DTO list
            landUseDTOS.add(landUseDTO);
        }
        // Return processed results
        return landUseDTOS;
    }

    @Override
    public String save(LandUseDTO landUseDTO) {
        LandUseEntity landUseEntity = LandUseDTOAndEntityConverter.convertToEntity(landUseDTO);
        landUseRepository.save(landUseEntity);
        return "Success";
    }
}
