package com.enviro.assessment.grad001.johnmootsi.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.LandUseDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.LandUseEntity;
import org.springframework.stereotype.Component;

@Component
public class LandUseEntityToDTOConverter {

    public LandUseDTO convertLandUseEntityToDTO(LandUseEntity landUseEntity) {

        LandUseDTO landUseDTO = new LandUseDTO();

        landUseDTO.setId(landUseEntity.getId());
        landUseDTO.setName(landUseEntity.getName());
        landUseDTO.setDescription(landUseEntity.getDescription());
        landUseDTO.setLocation(landUseEntity.getLocation());
        landUseDTO.setLandUseType(landUseEntity.getLandUseType());
        landUseDTO.setDate(landUseEntity.getDate());

        return landUseDTO;
    }
}
