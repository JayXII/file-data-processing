package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.LandUseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandUseRepository extends JpaRepository<LandUseEntity, Long> {
    LandUseEntity findByName(String name);
}
