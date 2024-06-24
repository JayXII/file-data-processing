package com.enviro.assessment.grad001.johnmootsi.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.AirQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.AirQualityEntity;
import org.springframework.stereotype.Component;

@Component
public class AirQualityEntityToDTOConverter {

    public AirQualityDTO convertAirQualityEntityToDTO(AirQualityEntity airQualityEntity) {

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
