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
        waterQualityEntity.setSampleValue(waterQualityDTO.getSampleValue());
//        waterQualityEntity.setSamplingDate(waterQualityDTO.getDate());

        return waterQualityEntity;
    }

    public WaterQualityDTO convertToDTO(WaterQualityEntity entity) {

        WaterQualityDTO waterQualityDTO = new WaterQualityDTO();

        waterQualityDTO.setId(entity.getId());
        waterQualityDTO.setName(entity.getName());
        waterQualityDTO.setDescription(entity.getDescription());
        waterQualityDTO.setParameter(waterQualityDTO.getParameter());
        waterQualityDTO.setSampleValue(waterQualityDTO.getSampleValue());
//        waterQualityDTO.setDate(waterQualityDTO.getDate());

        return waterQualityDTO;
    }
}
