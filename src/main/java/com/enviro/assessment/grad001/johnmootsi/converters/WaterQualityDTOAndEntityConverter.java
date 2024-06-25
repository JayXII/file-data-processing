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
        waterQualityEntity.setSamplingDate(waterQualityDTO.getSamplingDate());

        return waterQualityEntity;
    }

    public WaterQualityDTO convertToDTO(WaterQualityEntity waterQualityEntity) {

        WaterQualityDTO waterQualityDTO = new WaterQualityDTO();

        waterQualityDTO.setId(waterQualityEntity.getId());
        waterQualityDTO.setName(waterQualityEntity.getName());
        waterQualityDTO.setDescription(waterQualityEntity.getDescription());
        waterQualityDTO.setParameter(waterQualityEntity.getParameter());
        waterQualityDTO.setSampleValue(waterQualityEntity.getSampleValue());
        waterQualityDTO.setSamplingDate(waterQualityEntity.getSamplingDate());

        return waterQualityDTO;
    }
}
