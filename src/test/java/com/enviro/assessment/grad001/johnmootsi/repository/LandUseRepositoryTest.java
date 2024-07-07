package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.LandUseEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class LandUseRepositoryTest {
    // given - when - then
    @Autowired
    private LandUseRepository landUseRepository;
    private LandUseEntity landUseEntity;

    @BeforeEach
    void setUp() {
        landUseEntity = new LandUseEntity();
        landUseEntity.setName("Test Land Use");
        landUseEntity.setDescription("Test Description");
        landUseEntity.setLocation("Test Location");
        landUseEntity.setLandUseType("Test Land Use Type");
        landUseEntity.setSamplingDate(new Date(2024, Calendar.JULY, 4));

        landUseRepository.save(landUseEntity);
    }

    @AfterEach
    void tearDown() {
        landUseEntity = null;
        landUseRepository.deleteAll();
    }

    // Success test case
    @Test
    void findByNameContainingIgnoreCaseFound() {
        List<LandUseEntity> landUseEntities = landUseRepository.findByNameContainingIgnoreCase("test Land");
        assertThat(landUseEntities.get(0).getName()).isEqualTo("Test Land Use");
        assertThat(landUseEntities.get(0).getDescription()).isEqualTo("Test Description");
        assertThat(landUseEntities.get(0).getLocation()).isEqualTo("Test Location");
        assertThat(landUseEntities.get(0).getLandUseType()).isEqualTo("Test Land Use Type");
        assertThat(landUseEntities.get(0).getSamplingDate()).isNotNull();
    }

    // Failure test case
    @Test
    void findByNameContainingIgnoreCaseNotFound() {
        List<LandUseEntity> landUseEntities = landUseRepository.findByNameContainingIgnoreCase("foo");
        assertThat(landUseEntities).hasSize(0);
        assertThat(landUseEntities.isEmpty()).isTrue();
    }
}