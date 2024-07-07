package com.enviro.assessment.grad001.johnmootsi.dto;


import java.util.Date;
import java.util.Objects;

public class LandUseDTO {
    private Long id;
    private String name;
    private String description;
    private String location;
    private String landUseType;
    private Date samplingDate;

    public LandUseDTO() {
    }

    public LandUseDTO(Long id, String name, String description, String location, String landUseType, Date samplingDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.landUseType = landUseType;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLandUseType() {
        return landUseType;
    }

    public void setLandUseType(String landUseType) {
        this.landUseType = landUseType;
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
        LandUseDTO that = (LandUseDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(location, that.location) && Objects.equals(landUseType, that.landUseType) && Objects.equals(samplingDate, that.samplingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, location, landUseType, samplingDate);
    }

    @Override
    public String toString() {
        return "LandUseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", landUseType='" + landUseType + '\'' +
                ", samplingDate=" + samplingDate +
                '}';
    }
}
