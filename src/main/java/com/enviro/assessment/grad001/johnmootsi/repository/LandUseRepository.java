package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.LandUseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LandUseRepository extends JpaRepository<LandUseEntity, Long> {
    List<LandUseEntity> findByNameContainingIgnoreCase(String name);
}
