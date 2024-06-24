package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.DeforestationRatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeforestationRatesRepository extends JpaRepository<DeforestationRatesEntity, Long> {
    DeforestationRatesEntity findByName(String name);
}
