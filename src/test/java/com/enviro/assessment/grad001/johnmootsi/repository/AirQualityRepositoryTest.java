package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.AirQualityEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AirQualityRepositoryTest {
    // given - when - then
    @Autowired
    private AirQualityRepository airQualityRepository;
    private AirQualityEntity airQualityEntity;

    @BeforeEach
    void setUp() {
        airQualityEntity = new AirQualityEntity();
//        airQualityEntity.setId(1L);
        airQualityEntity.setName("Test Air Quality");
        airQualityEntity.setDescription("Test description");
        airQualityEntity.setMeasurementDate(new Date(2024, 07, 04));
        airQualityEntity.setConcentration("Test concentration");
        airQualityEntity.setPollutant("Test Pollutant");

        airQualityRepository.save(airQualityEntity);
    }

    @AfterEach
    void tearDown() {
        airQualityEntity = null;
        airQualityRepository.deleteAll();
    }

    // Success test case
    @Test
    void testFindByNameContainingIgnoreCaseFound() {
        List<AirQualityEntity> airQualityEntities = airQualityRepository.findByNameContainingIgnoreCase("test Air");
        assertThat(airQualityEntities).hasSize(1);
        assertThat(airQualityEntities.get(0).getName()).isEqualTo("Test Air Quality");
        assertThat(airQualityEntities.get(0).getDescription()).isEqualTo("Test description");
        assertThat(airQualityEntities.get(0).getMeasurementDate()).isInstanceOf(Date.class);
        assertThat(airQualityEntities.get(0).getConcentration()).isEqualTo("Test concentration");
        assertThat(airQualityEntities.get(0).getPollutant()).isEqualTo("Test Pollutant");
    }

    // Failure test case
    @Test
    void testFindByNameContainingIgnoreCaseNotFound() {
        List<AirQualityEntity> airQualityEntities = airQualityRepository.findByNameContainingIgnoreCase("Land");
        assertThat(airQualityEntities).hasSize(0);
        assertThat(airQualityEntities.isEmpty()).isTrue();
    }
}
