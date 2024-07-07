package com.enviro.assessment.grad001.johnmootsi.utility.converters;

import com.enviro.assessment.grad001.johnmootsi.dto.AirQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.AirQualityEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AirQualityDTOAndEntityConverter {

    public static AirQualityEntity convertToEntity(AirQualityDTO airQualityDTO) {

        AirQualityEntity airQualityEntity = new AirQualityEntity();

        airQualityEntity.setName(airQualityDTO.getName());
        airQualityEntity.setDescription(airQualityDTO.getDescription());
        airQualityEntity.setPollutant(airQualityDTO.getPollutant());
        airQualityEntity.setConcentration(airQualityDTO.getConcentration());
        airQualityEntity.setMeasurementDate(airQualityDTO.getMeasurementDate());

        return airQualityEntity;
    }

    public static AirQualityDTO convertToDTO(AirQualityEntity airQualityEntity) {

        AirQualityDTO airQualityDTO = new AirQualityDTO();

        airQualityDTO.setId(airQualityEntity.getId());
        airQualityDTO.setName(airQualityEntity.getName());
        airQualityDTO.setDescription(airQualityEntity.getDescription());
        airQualityDTO.setPollutant(airQualityEntity.getPollutant());
        airQualityDTO.setConcentration(airQualityEntity.getConcentration());
        airQualityDTO.setMeasurementDate(airQualityEntity.getMeasurementDate());

        return airQualityDTO;
    }

    public static AirQualityDTO convertToDTO(List<String> elements) {

        AirQualityDTO airQualityDTO = new AirQualityDTO();

        try {
            airQualityDTO.setName(elements.get(0));
            airQualityDTO.setDescription(elements.get(1));
            airQualityDTO.setPollutant(elements.get(3));
            airQualityDTO.setConcentration(elements.get(4));
            airQualityDTO.setMeasurementDate(new Date(elements.get(2)));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Error converting elements into AirQualityDTO, elements array out of bounds", e);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error converting String into Date,");
        } catch (Exception e) {
            throw new RuntimeException("Error converting elements into AirQualityDTO", e);
        }

        return airQualityDTO;
    }
}
