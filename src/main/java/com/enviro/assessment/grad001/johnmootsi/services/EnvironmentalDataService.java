package com.enviro.assessment.grad001.johnmootsi.services;

import com.enviro.assessment.grad001.johnmootsi.entities.EnvironmentalDataEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EnvironmentalDataService {
    public String upload(MultipartFile file);
    public EnvironmentalDataEntity getProcessedResultsById(Long id);
    public List<EnvironmentalDataEntity> getAllProcessedResults();
}
