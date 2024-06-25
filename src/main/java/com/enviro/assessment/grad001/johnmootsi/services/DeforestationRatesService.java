package com.enviro.assessment.grad001.johnmootsi.services;

import com.enviro.assessment.grad001.johnmootsi.dto.DeforestationRatesDTO;

import java.util.List;

public interface DeforestationRatesService {
    DeforestationRatesDTO findDeforestationRatesById(Long id);
    DeforestationRatesDTO findDeforestationRatesByName(String name);
    List<DeforestationRatesDTO> findAllDeforestationRates();
    void save(DeforestationRatesDTO deforestationRatesDTO);
}
