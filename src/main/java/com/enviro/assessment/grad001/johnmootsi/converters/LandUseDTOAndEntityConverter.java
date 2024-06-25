package com.enviro.assessment.grad001.johnmootsi.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.LandUseDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.LandUseEntity;
import org.springframework.stereotype.Component;

@Component
public class LandUseDTOAndEntityConverter {

    public LandUseEntity convertToEntity(LandUseDTO landUseDTO) {

        LandUseEntity landUseEntity = new LandUseEntity();

        landUseEntity.setName(landUseDTO.getName());
        landUseEntity.setDescription(landUseDTO.getDescription());
        landUseEntity.setLocation(landUseDTO.getLocation());
        landUseEntity.setLandUseType(landUseDTO.getLandUseType());
        landUseEntity.setSamplingDate(landUseDTO.getSamplingDate());

        return landUseEntity;
    }

    public LandUseDTO convertToDTO(LandUseEntity landUseEntity) {

        LandUseDTO landUseDTO = new LandUseDTO();

        landUseDTO.setId(landUseEntity.getId());
        landUseDTO.setName(landUseEntity.getName());
        landUseDTO.setDescription(landUseEntity.getDescription());
        landUseDTO.setLocation(landUseEntity.getLocation());
        landUseDTO.setLandUseType(landUseEntity.getLandUseType());
        landUseDTO.setSamplingDate(landUseEntity.getSamplingDate());

        return landUseDTO;
    }
}