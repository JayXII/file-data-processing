package com.enviro.assessment.grad001.johnmootsi.utility.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.AirQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.dto.WaterQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.WaterQualityEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class WaterQualityDTOAndEntityConverter {

    public static WaterQualityEntity convertToEntity(WaterQualityDTO waterQualityDTO) {

        WaterQualityEntity waterQualityEntity = new WaterQualityEntity();

        waterQualityEntity.setName(waterQualityDTO.getName());
        waterQualityEntity.setDescription(waterQualityDTO.getDescription());
        waterQualityEntity.setParameter(waterQualityDTO.getParameter());
        waterQualityEntity.setSampleValue(waterQualityDTO.getSampleValue());
        waterQualityEntity.setSamplingDate(waterQualityDTO.getSamplingDate());

        return waterQualityEntity;
    }

    public static WaterQualityDTO convertToDTO(WaterQualityEntity waterQualityEntity) {

        WaterQualityDTO waterQualityDTO = new WaterQualityDTO();

        waterQualityDTO.setId(waterQualityEntity.getId());
        waterQualityDTO.setName(waterQualityEntity.getName());
        waterQualityDTO.setDescription(waterQualityEntity.getDescription());
        waterQualityDTO.setParameter(waterQualityEntity.getParameter());
        waterQualityDTO.setSampleValue(waterQualityEntity.getSampleValue());
        waterQualityDTO.setSamplingDate(waterQualityEntity.getSamplingDate());

        return waterQualityDTO;
    }

    public static WaterQualityDTO convertToDTO(List<String> elements) {

        WaterQualityDTO waterQualityDTO = new WaterQualityDTO();

        try {
            waterQualityDTO.setName(elements.get(0));
            waterQualityDTO.setDescription(elements.get(1));
            waterQualityDTO.setParameter(elements.get(3));
            waterQualityDTO.setSampleValue(elements.get(4));
            waterQualityDTO.setSamplingDate(new Date(elements.get(2)));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Error converting elements into WaterQualityDTO, elements array out of bounds", e);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error converting String into Date,");
        } catch (Exception e) {
            throw new RuntimeException("Error converting elements into WaterQualityDTO", e);
        }

        return waterQualityDTO;
    }
}
