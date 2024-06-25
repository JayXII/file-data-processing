package com.enviro.assessment.grad001.johnmootsi.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.AirQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.AirQualityEntity;
import org.springframework.stereotype.Component;

@Component
public class AirQualityDTOAndEntityConverter {

    public AirQualityEntity convertToEntity(AirQualityDTO airQualityDTO) {

        AirQualityEntity airQualityEntity = new AirQualityEntity();

        airQualityEntity.setName(airQualityDTO.getName());
        airQualityEntity.setDescription(airQualityDTO.getDescription());
        airQualityEntity.setPollutant(airQualityDTO.getPollutant());
        airQualityEntity.setConcentration(airQualityDTO.getConcentration());
        airQualityEntity.setDate(airQualityDTO.getDate());

        return airQualityEntity;
    }

    public AirQualityDTO convertToDTO(AirQualityEntity airQualityEntity) {

        AirQualityDTO airQualityDTO = new AirQualityDTO();

        airQualityDTO.setId(airQualityEntity.getId());
        airQualityDTO.setName(airQualityEntity.getName());
        airQualityDTO.setDescription(airQualityEntity.getDescription());
        airQualityDTO.setPollutant(airQualityEntity.getPollutant());
        airQualityDTO.setConcentration(airQualityEntity.getConcentration());
        airQualityDTO.setDate(airQualityEntity.getDate());

        return airQualityDTO;
    }
}
