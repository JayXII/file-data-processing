package com.enviro.assessment.grad001.johnmootsi.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.DeforestationRatesDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.DeforestationRatesEntity;
import org.springframework.stereotype.Component;

@Component
public class DeforestationRatesDTOAndEntityConverter {

    public DeforestationRatesEntity convertToEntity(DeforestationRatesDTO deforestationRatesDTO) {

        DeforestationRatesEntity deforestationRatesEntity = new DeforestationRatesEntity();

        deforestationRatesEntity.setName(deforestationRatesDTO.getName());
        deforestationRatesEntity.setDescription(deforestationRatesDTO.getDescription());
        deforestationRatesEntity.setRegion(deforestationRatesDTO.getRegion());
        deforestationRatesEntity.setDeforestationRate(deforestationRatesDTO.getDeforestationRate());
        deforestationRatesEntity.setSoilOrganicCarbonRate(deforestationRatesDTO.getSoilOrganicCarbonRate());
        deforestationRatesEntity.setSoilNutrientLevels(deforestationRatesDTO.getSoilNutrientLevels());
        deforestationRatesEntity.setSamplingDate(deforestationRatesDTO.getSamplingDate());

        return deforestationRatesEntity;

    }

    public DeforestationRatesDTO convertToDTO(DeforestationRatesEntity deforestationRatesEntity) {

        DeforestationRatesDTO deforestationRatesDTO = new DeforestationRatesDTO();

        deforestationRatesDTO.setId(deforestationRatesEntity.getId());
        deforestationRatesDTO.setName(deforestationRatesEntity.getName());
        deforestationRatesDTO.setDescription(deforestationRatesEntity.getDescription());
        deforestationRatesDTO.setRegion(deforestationRatesEntity.getRegion());
        deforestationRatesDTO.setDeforestationRate(deforestationRatesEntity.getDeforestationRate());
        deforestationRatesDTO.setSoilOrganicCarbonRate(deforestationRatesEntity.getSoilOrganicCarbonRate());
        deforestationRatesDTO.setSoilNutrientLevels(deforestationRatesEntity.getSoilNutrientLevels());
        deforestationRatesDTO.setSamplingDate(deforestationRatesEntity.getSamplingDate());

        return deforestationRatesDTO;
    }
}