package com.enviro.assessment.grad001.johnmootsi.services;

import com.enviro.assessment.grad001.johnmootsi.dto.ProcessedResultsDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EnvironmentalDataService {
    String upload(MultipartFile file);
    ProcessedResultsDTO getProcessedResultsById(Long id);
    ProcessedResultsDTO getProcessedResultsByName(String name);
    List<ProcessedResultsDTO> getAllProcessedResults();
}
