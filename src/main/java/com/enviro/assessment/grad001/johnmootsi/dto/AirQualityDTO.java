package com.enviro.assessment.grad001.johnmootsi.dto;


import java.util.Date;
import java.util.Objects;

public class AirQualityDTO {
    private Long id;
    private String name;
    private String description;
    private String pollutant;
    private String concentration;
    private Date measurementDate;

    public AirQualityDTO() {
    }

    public AirQualityDTO(Long id, String name, String description, String pollutant, String concentration, Date measurementDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pollutant = pollutant;
        this.concentration = concentration;
        this.measurementDate = measurementDate;
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

    public String getPollutant() {
        return pollutant;
    }

    public void setPollutant(String pollutant) {
        this.pollutant = pollutant;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public Date getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(Date measurementDate) {
        this.measurementDate = measurementDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirQualityDTO that = (AirQualityDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(pollutant, that.pollutant) && Objects.equals(concentration, that.concentration) && Objects.equals(measurementDate, that.measurementDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, pollutant, concentration, measurementDate);
    }

    @Override
    public String toString() {
        return "AirQualityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pollutant='" + pollutant + '\'' +
                ", concentration='" + concentration + '\'' +
                ", measurementDate=" + measurementDate +
                '}';
    }
}
