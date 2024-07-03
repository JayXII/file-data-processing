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
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

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
        try {
            // Scanner object to read files
            Scanner scanner = new Scanner(new File(Objects.requireNonNull(file.getOriginalFilename())));
            // Read file lines and add them to DTO's
            AirQualityDTO airQualityDTO = new AirQualityDTO();
            airQualityDTO.setName(scanner.nextLine().split(":")[1]);
            airQualityDTO.setDescription(scanner.nextLine().split(":")[1]);
            airQualityDTO.setMeasurementDate(new Date(scanner.nextLine().split(":")[1].strip()));
            airQualityDTO.setPollutant(scanner.nextLine().split(":")[1]);
            airQualityDTO.setConcentration(scanner.nextLine().split(":")[1]);

            // Convert and save the entity to database
            AirQualityEntity airQualityEntity = airQualityDTOAndEntityConverter.convertToEntity(airQualityDTO);
            airQualityRepository.save(airQualityEntity);

            scanner.nextLine();

            WaterQualityDTO waterQualityDTO = new WaterQualityDTO();
            waterQualityDTO.setName(scanner.nextLine().split(":")[1]);
            waterQualityDTO.setDescription(scanner.nextLine().split(":")[1]);
            waterQualityDTO.setSamplingDate(new Date(scanner.nextLine().split(":")[1].strip()));
            waterQualityDTO.setParameter(scanner.nextLine().split(":")[1]);
            waterQualityDTO.setSampleValue(scanner.nextLine().split(":")[1]);

            // Convert and save the entity to database
            WaterQualityEntity waterQualityEntity = waterQualityDTOAndEntityConverter.convertToEntity(waterQualityDTO);
            waterQualityRepository.save(waterQualityEntity);

            scanner.nextLine();

            LandUseDTO landUseDTO = new LandUseDTO();
            landUseDTO.setName(scanner.nextLine().split(":")[1]);
            landUseDTO.setDescription(scanner.nextLine().split(":")[1]);
            landUseDTO.setLocation(scanner.nextLine().split(":")[1]);
            landUseDTO.setLandUseType(scanner.nextLine().split(":")[1]);
            landUseDTO.setSamplingDate(new Date(scanner.nextLine().split(":")[1]));

            // Convert and save the entity to database
            LandUseEntity landUseEntity = landUseDTOAndEntityConverter.convertToEntity(landUseDTO);
            landUseRepository.save(landUseEntity);

            scanner.nextLine();

            DeforestationRatesDTO deforestationRatesDTO = new DeforestationRatesDTO();
            deforestationRatesDTO.setName(scanner.nextLine().split(":")[1]);
            deforestationRatesDTO.setDescription(scanner.nextLine().split(":")[1]);
            deforestationRatesDTO.setRegion(scanner.nextLine().split(":")[1]);
            deforestationRatesDTO.setSamplingDate(new Date(scanner.nextLine().split(":")[1].strip()));
            deforestationRatesDTO.setDeforestationRate(scanner.nextLine().split(":")[1]);
            deforestationRatesDTO.setSoilOrganicCarbonRate(scanner.nextLine().split(":")[1]);
            deforestationRatesDTO.setSoilNutrientLevels(scanner.nextLine().split(":")[1]);

            // Convert and save the entity to database
            DeforestationRatesEntity deforestationRatesEntity = deforestationRatesDTOAndEntityConverter.convertToEntity(deforestationRatesDTO);
            deforestationRatesRepository.save(deforestationRatesEntity);

            scanner.close();

            return "Upload successful";
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
