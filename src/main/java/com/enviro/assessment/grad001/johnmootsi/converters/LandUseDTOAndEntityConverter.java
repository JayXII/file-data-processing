package com.enviro.assessment.grad001.johnmootsi.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.LandUseDTO;
import com.enviro.assessment.grad001.johnmootsi.dto.WaterQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.LandUseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

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

    public LandUseDTO convertToDTO(List<String> elements) {

        LandUseDTO landUseDTO = new LandUseDTO();

        try {
            landUseDTO.setName(elements.get(0));
            landUseDTO.setDescription(elements.get(1));
            landUseDTO.setLocation(elements.get(2));
            landUseDTO.setLandUseType(elements.get(3));
            landUseDTO.setSamplingDate(new Date(elements.get(4)));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Error converting elements into LandUseDTO, elements array out of bounds", e);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error converting String into Date,");
        } catch (Exception e) {
            throw new RuntimeException("Error converting elements into LandUseDTO", e);
        }

        return landUseDTO;
    }
}