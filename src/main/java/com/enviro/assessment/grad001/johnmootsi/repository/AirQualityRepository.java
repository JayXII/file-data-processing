package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.AirQualityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirQualityRepository extends JpaRepository<AirQualityEntity, Long> {
    List<AirQualityEntity> findByNameContainingIgnoreCase(String name);
}
