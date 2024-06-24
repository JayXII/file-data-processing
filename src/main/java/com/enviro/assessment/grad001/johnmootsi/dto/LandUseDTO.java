package com.enviro.assessment.grad001.johnmootsi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LandUseDTO extends ProcessedResultsDTO {
    private Long id;
    private String name;
    private String description;
    private String location;
    private String landUseType;
    private Date date;
}
