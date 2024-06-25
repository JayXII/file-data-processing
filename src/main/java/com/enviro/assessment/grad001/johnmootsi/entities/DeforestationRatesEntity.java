package com.enviro.assessment.grad001.johnmootsi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "DEFORESTATION_RATES")
@Getter
@Setter
@NoArgsConstructor
public class DeforestationRatesEntity extends ProcessedResultsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "REGION")
    private String region;
    @Column(name = "DEFORESTATION_RATE")
    private String deforestationRate;
    @Column(name = "SOIL_ORGANIC_CARBON_RATE")
    private String soilOrganicCarbonRate;
    @Column(name = "SOIL_NUTRIENT_LEVELS")
    private String soilNutrientLevels;
    @Column(name = "SAMPLING_DATE")
    private Date samplingDate;
}
