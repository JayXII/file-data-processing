package com.enviro.assessment.grad001.johnmootsi.services;

import com.enviro.assessment.grad001.johnmootsi.dto.AirQualityDTO;

import java.util.List;

public interface AirQualityService {
    AirQualityDTO findAirQualityById(Long id);
    AirQualityDTO findAirQualityByName(String name);
    List<AirQualityDTO> findAllAirQuality();
    void save(AirQualityDTO airQualityDTO);
}
