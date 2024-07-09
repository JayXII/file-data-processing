package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.utility.handlers.ProcessFileResponseHandler;
import com.enviro.assessment.grad001.johnmootsi.services.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1")
public class FileUploadController {

    private final FileUploadService fileUploadService;
    private final ProcessFileResponseHandler response;

    public FileUploadController(FileUploadService fileUploadService, ProcessFileResponseHandler response) {
        this.fileUploadService = fileUploadService;
        this.response = response;
    }

    // File upload endpoint
    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProcessFileResponseHandler> processFile(@RequestParam("file") MultipartFile file) {
        String message = fileUploadService.upload(file);
        response.setMessage(message);
        return ResponseEntity.ok(response);
    }

}
