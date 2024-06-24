package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.AirQualityEntity;
import com.enviro.assessment.grad001.johnmootsi.entities.ProcessedResultsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentalDataRepository extends JpaRepository<AirQualityEntity, Long> {
//    ProcessedResultsEntity findAllByEnvironmentName(String environmentName);
//    ProcessedResultsEntity findByEnvironmentName(String environmentName);
//    ProcessedResultsEntity findByName(String name);

}
