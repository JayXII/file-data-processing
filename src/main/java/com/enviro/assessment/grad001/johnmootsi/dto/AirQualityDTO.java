package com.enviro.assessment.grad001.johnmootsi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AirQualityDTO {
    private Long id;
    private String name;
    private String description;
    private String pollutant;
    private String concentration;
    private Date measurementDate;
}
