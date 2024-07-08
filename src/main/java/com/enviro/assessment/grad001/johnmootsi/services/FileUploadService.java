package com.enviro.assessment.grad001.johnmootsi.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String upload(MultipartFile file);
}
