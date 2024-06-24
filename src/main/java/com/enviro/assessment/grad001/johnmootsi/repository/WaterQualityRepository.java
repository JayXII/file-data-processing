package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.WaterQualityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterQualityRepository extends JpaRepository<WaterQualityEntity, Long> {
    WaterQualityEntity findByName(String name);
}
