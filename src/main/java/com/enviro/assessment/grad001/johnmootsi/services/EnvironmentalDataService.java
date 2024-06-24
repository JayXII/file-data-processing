package com.enviro.assessment.grad001.johnmootsi.services;

import com.enviro.assessment.grad001.johnmootsi.dto.ProcessedResultsDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EnvironmentalDataService {
    public String upload(MultipartFile file);
    public ProcessedResultsDTO getProcessedResultsById(Long id);
    public ProcessedResultsDTO getProcessedResultsByName(String name);
    public List<ProcessedResultsDTO> getAllProcessedResults();
}
