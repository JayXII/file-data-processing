package com.enviro.assessment.grad001.johnmootsi.dto;


import java.util.Date;
import java.util.Objects;

public class WaterQualityDTO {
    private Long id;
    private String name;
    private String description;
    private String parameter;
    private String sampleValue;
    private Date samplingDate;

    public WaterQualityDTO() {
    }

    public WaterQualityDTO(Long id, String name, String description, String parameter, String sampleValue, Date samplingDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parameter = parameter;
        this.sampleValue = sampleValue;
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

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getSampleValue() {
        return sampleValue;
    }

    public void setSampleValue(String sampleValue) {
        this.sampleValue = sampleValue;
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
        WaterQualityDTO that = (WaterQualityDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(parameter, that.parameter) && Objects.equals(sampleValue, that.sampleValue) && Objects.equals(samplingDate, that.samplingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, parameter, sampleValue, samplingDate);
    }

    @Override
    public String toString() {
        return "WaterQualityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parameter='" + parameter + '\'' +
                ", sampleValue='" + sampleValue + '\'' +
                ", samplingDate=" + samplingDate +
                '}';
    }
}
