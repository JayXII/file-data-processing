package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.WaterQualityEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class WaterQualityRepositoryTest {
    // given - when - then
    @Autowired
    private WaterQualityRepository waterQualityRepository;
    private WaterQualityEntity waterQualityEntity;

    @BeforeEach
    void setUp() {
        waterQualityEntity = new WaterQualityEntity();
        waterQualityEntity.setId(1L);
        waterQualityEntity.setName("Test Water Quality");
        waterQualityEntity.setDescription("Test Description");
        waterQualityEntity.setSampleValue("Test Sample Value");
        waterQualityEntity.setParameter("Test Parameter Value");
        waterQualityEntity.setSamplingDate(new Date(2024, Calendar.JULY, 4));
        waterQualityRepository.save(waterQualityEntity);
    }

    @AfterEach
    void tearDown() {
        waterQualityEntity = null;
        waterQualityRepository.deleteAll();
    }

    // Success test case
    @Test
    void testFindByNameContainingIgnoreCaseFound() {
        List<WaterQualityEntity> waterQualityEntities = waterQualityRepository.findByNameContainingIgnoreCase("test Water");
        assertThat(waterQualityEntities.get(0).getName()).isEqualTo("Test Water Quality");
        assertThat(waterQualityEntities.get(0).getDescription()).isEqualTo("Test Description");
        assertThat(waterQualityEntities.get(0).getSampleValue()).isEqualTo("Test Sample Value");
        assertThat(waterQualityEntities.get(0).getParameter()).isEqualTo("Test Parameter Value");
        assertThat(waterQualityEntities.get(0).getSamplingDate()).isNotNull();
        assertThat(waterQualityEntities.get(0).getId()).isEqualTo(1L);
    }

    // Failure test case
    @Test
    void testFindByNameContainingIgnoreCaseNotFound() {
        List<WaterQualityEntity> waterQualityEntities = waterQualityRepository.findByNameContainingIgnoreCase("foo");
        assertThat(waterQualityEntities).hasSize(0);
        assertThat(waterQualityEntities.isEmpty()).isTrue();
    }
}