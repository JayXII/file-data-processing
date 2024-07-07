package com.enviro.assessment.grad001.johnmootsi.dto;

import java.util.Date;
import java.util.Objects;

public class DeforestationRatesDTO {
    private Long id;
    private String name;
    private String description;
    private String region;
    private String deforestationRate;
    private String soilOrganicCarbonRate;
    private String soilNutrientLevels;
    private Date samplingDate;

    public DeforestationRatesDTO() {
    }

    public DeforestationRatesDTO(Long id, String name, String description, String region,
                                 String deforestationRate, String soilOrganicCarbonRate,
                                 String soilNutrientLevels, Date samplingDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.region = region;
        this.deforestationRate = deforestationRate;
        this.soilOrganicCarbonRate = soilOrganicCarbonRate;
        this.soilNutrientLevels = soilNutrientLevels;
        this.samplingDate = samplingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDeforestationRate() {
        return deforestationRate;
    }

    public void setDeforestationRate(String deforestationRate) {
        this.deforestationRate = deforestationRate;
    }

    public String getSoilOrganicCarbonRate() {
        return soilOrganicCarbonRate;
    }

    public void setSoilOrganicCarbonRate(String soilOrganicCarbonRate) {
        this.soilOrganicCarbonRate = soilOrganicCarbonRate;
    }

    public String getSoilNutrientLevels() {
        return soilNutrientLevels;
    }

    public void setSoilNutrientLevels(String soilNutrientLevels) {
        this.soilNutrientLevels = soilNutrientLevels;
    }

    public Date getSamplingDate() {
        return samplingDate;
    }

    public void setSamplingDate(Date samplingDate) {
        this.samplingDate = samplingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeforestationRatesDTO that = (DeforestationRatesDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(region, that.region) && Objects.equals(deforestationRate, that.deforestationRate) && Objects.equals(soilOrganicCarbonRate, that.soilOrganicCarbonRate) && Objects.equals(soilNutrientLevels, that.soilNutrientLevels) && Objects.equals(samplingDate, that.samplingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, region, deforestationRate, soilOrganicCarbonRate, soilNutrientLevels, samplingDate);
    }

    @Override
    public String toString() {
        return "DeforestationRatesDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", region='" + region + '\'' +
                ", deforestationRate='" + deforestationRate + '\'' +
                ", soilOrganicCarbonRate='" + soilOrganicCarbonRate + '\'' +
                ", soilNutrientLevels='" + soilNutrientLevels + '\'' +
                ", samplingDate=" + samplingDate +
                '}';
    }
}
