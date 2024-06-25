package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.converters.DeforestationRatesDTOAndEntityConverter;
import com.enviro.assessment.grad001.johnmootsi.dto.DeforestationRatesDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.DeforestationRatesEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.DeforestationRatesRepository;
import com.enviro.assessment.grad001.johnmootsi.services.DeforestationRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeforestationRatesServiceImplementation implements DeforestationRatesService {

    @Autowired
    private DeforestationRatesRepository deforestationRatesRepository;
    @Autowired
    private DeforestationRatesDTOAndEntityConverter deforestationRatesDTOAndEntityConverter;

    @Override
    public DeforestationRatesDTO findDeforestationRatesById(Long id) {
        DeforestationRatesDTO deforestationRatesDTO = null;
        // Find Deforestation Rates results by id
        Optional<DeforestationRatesEntity> optionalDeforestationRatesEntity = deforestationRatesRepository.findById(id);
        // Convert Entity to DTO if it exists
        if (optionalDeforestationRatesEntity.isPresent()) {
            DeforestationRatesEntity deforestationRatesEntity = optionalDeforestationRatesEntity.get();
            deforestationRatesDTO = deforestationRatesDTOAndEntityConverter.convertToDTO(deforestationRatesEntity);
        }
        // Return processed results
        return deforestationRatesDTO;
    }

    @Override
    public DeforestationRatesDTO findDeforestationRatesByName(String name) {
        // Find Deforestation Rates results by name
        DeforestationRatesEntity deforestationRatesEntity = deforestationRatesRepository.findByName(name);
        // Convert Entity to DTO
        DeforestationRatesDTO deforestationRatesDTO = deforestationRatesDTOAndEntityConverter.convertToDTO(deforestationRatesEntity);
        // Return processed results
        return deforestationRatesDTO;
    }

    @Override
    public List<DeforestationRatesDTO> findAllDeforestationRates() {
        // Find all Deforestation Rates results
        List<DeforestationRatesEntity> deforestationRatesEntities = deforestationRatesRepository.findAll();
        // Convert Entity to DTO by iterating over Deforestation Rates entity list
        List<DeforestationRatesDTO> deforestationRatesDTOS = new ArrayList<>();

        for (DeforestationRatesEntity deforestationRatesEntity : deforestationRatesEntities) {
            // Convert Entity to DTO
            DeforestationRatesDTO deforestationRatesDTO = deforestationRatesDTOAndEntityConverter.convertToDTO(deforestationRatesEntity);
            // Add to the DTO list
            deforestationRatesDTOS.add(deforestationRatesDTO);
        }
        // Return processed results
        return deforestationRatesDTOS;
    }

    @Override
    public void save(DeforestationRatesDTO deforestationRatesDTO) {
        DeforestationRatesEntity deforestationRatesEntity = deforestationRatesDTOAndEntityConverter.convertToEntity(deforestationRatesDTO);
        deforestationRatesRepository.save(deforestationRatesEntity);
    }
}
