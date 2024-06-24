package com.enviro.assessment.grad001.johnmootsi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "WATER QUALITY")
@Getter
@Setter
@NoArgsConstructor
public class WaterQualityEntity extends ProcessedResultsEntity {

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
    @Column(name = "VALUE")
    private String value;
    @Column(name = "DATE")
    private Date date;
}
