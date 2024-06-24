package com.enviro.assessment.grad001.johnmootsi.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.DeforestationRatesEntityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.DeforestationRatesEntity;
import org.springframework.stereotype.Component;

@Component
public class DeforestationRatesEntityToDTOConverter {

    public DeforestationRatesEntityDTO convertDeforestationEntityToDTO(DeforestationRatesEntity deforestationRatesEntity) {

        DeforestationRatesEntityDTO deforestationRatesDTO = new DeforestationRatesEntityDTO();
        deforestationRatesDTO.setId(deforestationRatesEntity.getId());
        deforestationRatesDTO.setName(deforestationRatesEntity.getName());
        deforestationRatesDTO.setDescription(deforestationRatesEntity.getDescription());
        deforestationRatesDTO.setRegion(deforestationRatesEntity.getRegion());
        deforestationRatesDTO.setDeforestationRate(deforestationRatesEntity.getDeforestationRate());
        deforestationRatesDTO.setSoilOrganicCarbonRate(deforestationRatesEntity.getSoilOrganicCarbonRate());
        deforestationRatesDTO.setSoilNutrientLevels(deforestationRatesEntity.getSoilNutrientLevels());
        deforestationRatesDTO.setDate(deforestationRatesEntity.getDate());
        return deforestationRatesDTO;
    }
}
