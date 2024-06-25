package com.enviro.assessment.grad001.johnmootsi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DeforestationRatesDTO extends ProcessedResultsDTO {
    private Long id;
    private String name;
    private String description;
    private String region;
    private String deforestationRate;
    private String soilOrganicCarbonRate;
    private String soilNutrientLevels;
    private Date samplingDate;
}
