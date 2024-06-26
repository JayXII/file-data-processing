package com.enviro.assessment.grad001.johnmootsi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WaterQualityDTO {
    private Long id;
    private String name;
    private String description;
    private String parameter;
    private String sampleValue;
    private Date samplingDate;
}
