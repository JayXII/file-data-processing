package com.enviro.assessment.grad001.johnmootsi.services;

import com.enviro.assessment.grad001.johnmootsi.dto.LandUseDTO;

import java.util.List;

public interface LandUseService {
    LandUseDTO findLandUseById(Long id);
    LandUseDTO findLandUseByName(String name);
    List<LandUseDTO> findAllLandUse();
    void save(LandUseDTO landUseDTO);
}
