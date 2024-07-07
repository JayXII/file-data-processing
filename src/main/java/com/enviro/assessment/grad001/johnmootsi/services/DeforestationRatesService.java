package com.enviro.assessment.grad001.johnmootsi.services;

import com.enviro.assessment.grad001.johnmootsi.dto.DeforestationRatesDTO;

import java.util.List;

public interface DeforestationRatesService {
    DeforestationRatesDTO findDeforestationRatesById(Long id);
    List<DeforestationRatesDTO> findDeforestationRatesByName(String name);
    List<DeforestationRatesDTO> findAllDeforestationRates();
    String save(DeforestationRatesDTO deforestationRatesDTO);
}