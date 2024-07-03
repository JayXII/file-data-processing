package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.converters.AirQualityDTOAndEntityConverter;
import com.enviro.assessment.grad001.johnmootsi.converters.DeforestationRatesDTOAndEntityConverter;
import com.enviro.assessment.grad001.johnmootsi.converters.LandUseDTOAndEntityConverter;
import com.enviro.assessment.grad001.johnmootsi.converters.WaterQualityDTOAndEntityConverter;
import com.enviro.assessment.grad001.johnmootsi.dto.*;
import com.enviro.assessment.grad001.johnmootsi.entities.AirQualityEntity;
import com.enviro.assessment.grad001.johnmootsi.entities.DeforestationRatesEntity;
import com.enviro.assessment.grad001.johnmootsi.entities.LandUseEntity;
import com.enviro.assessment.grad001.johnmootsi.entities.WaterQualityEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.*;
import com.enviro.assessment.grad001.johnmootsi.services.EnvironmentalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class EnvironmentalDataServiceImplementation implements EnvironmentalDataService {

    @Autowired
    private AirQualityRepository airQualityRepository;
    @Autowired
    private DeforestationRatesRepository deforestationRatesRepository;
    @Autowired
    private LandUseRepository landUseRepository;
    @Autowired
    private WaterQualityRepository waterQualityRepository;
    @Autowired
    private AirQualityDTOAndEntityConverter airQualityDTOAndEntityConverter;
    @Autowired
    private WaterQualityDTOAndEntityConverter waterQualityDTOAndEntityConverter;
    @Autowired
    private LandUseDTOAndEntityConverter landUseDTOAndEntityConverter;
    @Autowired
    private DeforestationRatesDTOAndEntityConverter deforestationRatesDTOAndEntityConverter;


    @Override
    public String upload(MultipartFile file){
        // Local vars
        List<String> contents = new ArrayList<>();
        String datasetName = "";
        String line = "";

        try {
            // Scanner object to read files
            Scanner scanner = new Scanner(new File(Objects.requireNonNull(file.getOriginalFilename())));

            // Read a line
            while (scanner.hasNextLine() || !contents.isEmpty()) {
                // Account for the remaining data in the list when there's no more lines to read
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                } else {
                    datasetName = "empty line";
                }

                // Split the line at ":" if the line is not empty
                // Get the dataset name
                if (line.equals("")) {
                    datasetName = "empty line";
                }
                if (line.toLowerCase().startsWith("dataset")) {
                    datasetName = line.split(":")[1];
                    contents.add(datasetName);
                }

                // Call the DTO converter that corresponds to the dataset name
                else if (datasetName.equals("empty line")) {
                    if (contents.get(0).toLowerCase().contains("air")) {
                        // Add contents to the DTO
                        AirQualityDTO airQualityDTO = airQualityDTOAndEntityConverter.convertToDTO(contents);

                        // Convert and save the entity to database
                        AirQualityEntity airQualityEntity = airQualityDTOAndEntityConverter.convertToEntity(airQualityDTO);
                        airQualityRepository.save(airQualityEntity);
                        contents.clear();
                    } else if (contents.get(0).toLowerCase().contains("water")) {
                        // Add contents to the DTO
                        WaterQualityDTO airQualityDTO = waterQualityDTOAndEntityConverter.convertToDTO(contents);

                        // Convert and save the entity to database
                        WaterQualityEntity waterQualityEntity = waterQualityDTOAndEntityConverter.convertToEntity(airQualityDTO);
                        waterQualityRepository.save(waterQualityEntity);
                        contents.clear();
                    } else if (contents.get(0).toLowerCase().contains("deforestation")) {
                        // Add contents to the DTO
                        DeforestationRatesDTO deforestationRatesDTO = deforestationRatesDTOAndEntityConverter.convertToDTO(contents);

                        // Convert and save the entity to database
                        DeforestationRatesEntity deforestationRatesEntity = deforestationRatesDTOAndEntityConverter.convertToEntity(deforestationRatesDTO);
                        deforestationRatesRepository.save(deforestationRatesEntity);
                        contents.clear();
                    } else if (contents.get(0).toLowerCase().contains("land")) {
                        // Add contents to the DTO
                        LandUseDTO landUseDTO = landUseDTOAndEntityConverter.convertToDTO(contents);

                        // Convert and save the entity to database
                        LandUseEntity landUseEntity = landUseDTOAndEntityConverter.convertToEntity(landUseDTO);
                        landUseRepository.save(landUseEntity);
                        contents.clear();
                    }
                } else {
                    // Add contents to the list
                    contents.add(line.split(":")[1]);
                }
            }

            scanner.close();
            return "Upload successful";
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
