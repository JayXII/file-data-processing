package com.enviro.assessment.grad001.johnmootsi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "LAND_USE")
@Getter
@Setter
@NoArgsConstructor
public class LandUseEntity extends ProcessedResultsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "LAND_USE_TYPE")
    private String landUseType;
    @Column(name = "SAMPLING_DATE")
    private Date samplingDate;
}
