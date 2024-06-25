package com.enviro.assessment.grad001.johnmootsi.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.WaterQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.WaterQualityEntity;
import org.springframework.stereotype.Component;

@Component
public class WaterQualityDTOAndEntityConverter {

    public WaterQualityEntity convertToEntity(WaterQualityDTO waterQualityDTO) {

        WaterQualityEntity waterQualityEntity = new WaterQualityEntity();

        waterQualityEntity.setName(waterQualityDTO.getName());
        waterQualityEntity.setDescription(waterQualityDTO.getDescription());
        waterQualityEntity.setParameter(waterQualityDTO.getParameter());
        waterQualityEntity.setValue(waterQualityDTO.getValue());
        waterQualityEntity.setDate(waterQualityDTO.getDate());

        return waterQualityEntity;
    }

    public WaterQualityDTO convertToDTO(WaterQualityEntity entity) {

        WaterQualityDTO waterQualityDTO = new WaterQualityDTO();

        waterQualityDTO.setId(entity.getId());
        waterQualityDTO.setName(entity.getName());
        waterQualityDTO.setDescription(entity.getDescription());
        waterQualityDTO.setParameter(waterQualityDTO.getParameter());
        waterQualityDTO.setValue(waterQualityDTO.getValue());
        waterQualityDTO.setDate(waterQualityDTO.getDate());

        return waterQualityDTO;
    }
}
