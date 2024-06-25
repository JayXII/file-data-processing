package com.enviro.assessment.grad001.johnmootsi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "AIR_QUALITY")
@Getter
@Setter
@NoArgsConstructor
public class AirQualityEntity extends ProcessedResultsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "POLLUTANT")
    private String pollutant;
    @Column(name = "CONCENTRATION")
    private String concentration;
    @Column(name = "MEASUREMENT_DATE")
    private Date measurementDate;
}
