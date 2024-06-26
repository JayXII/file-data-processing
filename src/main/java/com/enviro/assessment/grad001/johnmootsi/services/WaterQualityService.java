package com.enviro.assessment.grad001.johnmootsi.services;

import com.enviro.assessment.grad001.johnmootsi.dto.WaterQualityDTO;

import java.util.List;

public interface WaterQualityService {
    WaterQualityDTO findWaterQualityById(Long id);
    List<WaterQualityDTO> findWaterQualityByName(String name);
    List<WaterQualityDTO> findAllWaterQuality();
    void save(WaterQualityDTO waterQualityDTO);
}
