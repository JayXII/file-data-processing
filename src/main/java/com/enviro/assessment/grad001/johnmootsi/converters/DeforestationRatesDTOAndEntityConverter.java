package com.enviro.assessment.grad001.johnmootsi.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.DeforestationRatesDTO;
import com.enviro.assessment.grad001.johnmootsi.dto.WaterQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.DeforestationRatesEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

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

    public DeforestationRatesDTO convertToDTO(List<String> elements) {

        DeforestationRatesDTO deforestationRatesDTO = new DeforestationRatesDTO();

        try {
            deforestationRatesDTO.setName(elements.get(0));
            deforestationRatesDTO.setDescription(elements.get(1));
            deforestationRatesDTO.setRegion(elements.get(2));
            deforestationRatesDTO.setDeforestationRate(elements.get(4));
            deforestationRatesDTO.setSoilOrganicCarbonRate(elements.get(5));
            deforestationRatesDTO.setSoilNutrientLevels(elements.get(6));
            deforestationRatesDTO.setSamplingDate(new Date(elements.get(3)));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Error converting elements into DeforestationRatesDTO, elements array out of bounds", e);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error converting String into Date,");
        } catch (Exception e) {
            throw new RuntimeException("Error converting elements into DeforestationRatesDTO", e);
        }

        return deforestationRatesDTO;
    }
}