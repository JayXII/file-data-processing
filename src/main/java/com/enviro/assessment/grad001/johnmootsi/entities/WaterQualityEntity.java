package com.enviro.assessment.grad001.johnmootsi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "WATER_QUALITY")
@Getter
@Setter
@NoArgsConstructor
public class WaterQualityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PARAMETER")
    private String parameter;
    @Column(name = "SAMPLE_VALUE")
    private String sampleValue;
    @Column(name = "SAMPLING_DATE")
    private Date samplingDate;
}
