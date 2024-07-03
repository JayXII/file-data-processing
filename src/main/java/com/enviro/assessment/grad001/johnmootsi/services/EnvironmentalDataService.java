package com.enviro.assessment.grad001.johnmootsi.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface EnvironmentalDataService {
    String upload(MultipartFile file);
}
