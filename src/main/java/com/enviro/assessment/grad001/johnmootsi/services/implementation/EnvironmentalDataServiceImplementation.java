package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.entities.EnvironmentalDataEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.EnvironmentalDataRepository;
import com.enviro.assessment.grad001.johnmootsi.services.EnvironmentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EnvironmentalDataServiceImplementation implements EnvironmentalDataService {

    @Autowired
    private EnvironmentalDataRepository environmentalDataRepository;

    @Override
    public String upload(MultipartFile file) {
        return "";
    }

    @Override
    public EnvironmentalDataEntity getProcessedResultsById(Long id) {
        return null;
    }

    @Override
    public List<EnvironmentalDataEntity> getAllProcessedResults() {
        return List.of();
    }
}
