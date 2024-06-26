package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.DeforestationRatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeforestationRatesRepository extends JpaRepository<DeforestationRatesEntity, Long> {
    List<DeforestationRatesEntity> findByNameContainingIgnoreCase(String name);
}
