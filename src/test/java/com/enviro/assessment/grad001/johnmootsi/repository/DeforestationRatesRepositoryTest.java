package com.enviro.assessment.grad001.johnmootsi.repository;

import com.enviro.assessment.grad001.johnmootsi.entities.DeforestationRatesEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DeforestationRatesRepositoryTest {
    // given - when - then
    @Autowired
    private DeforestationRatesRepository deforestationRatesRepository;
    private DeforestationRatesEntity deforestationRatesEntity;

    @BeforeEach
    void setUp() {
        deforestationRatesEntity = new DeforestationRatesEntity();
        deforestationRatesEntity.setName("Test Deforestation Rates");
        deforestationRatesEntity.setDescription("Test Deforestation Rates Description");
        deforestationRatesEntity.setRegion("Test Region");
        deforestationRatesEntity.setDeforestationRate("Test Deforestation Rate");
        deforestationRatesEntity.setSoilOrganicCarbonRate("Test Soil Organic Carbon");
        deforestationRatesEntity.setSoilNutrientLevels("Test Soil Nutrient Levels");
        deforestationRatesEntity.setSamplingDate(new Date(2024, 07, 04));

        deforestationRatesRepository.save(deforestationRatesEntity);
    }

    @AfterEach
    void tearDown() {
        deforestationRatesEntity = null;
        deforestationRatesRepository.deleteAll();
    }

    // Success test case
    @Test
    void testFindByNameContainingIgnoreCaseFound() {
        List<DeforestationRatesEntity> deforestationRatesEntities = deforestationRatesRepository.findByNameContainingIgnoreCase("Test deforestation");
        assertThat(deforestationRatesEntities.get(0).getName()).isEqualTo("Test Deforestation Rates");
        assertThat(deforestationRatesEntities.get(0).getDescription()).isEqualTo("Test Deforestation Rates Description");
        assertThat(deforestationRatesEntities.get(0).getRegion()).isEqualTo("Test Region");
        assertThat(deforestationRatesEntities.get(0).getDeforestationRate()).isEqualTo("Test Deforestation Rate");
        assertThat(deforestationRatesEntities.get(0).getSoilOrganicCarbonRate()).isEqualTo("Test Soil Organic Carbon");
    }

    // Failure test case
    @Test
    void testFindByNameContainingIgnoreCaseNotFound() {
        List<DeforestationRatesEntity> deforestationRatesEntities = deforestationRatesRepository.findByNameContainingIgnoreCase("air");
        assertThat(deforestationRatesEntities.isEmpty()).isTrue();
        assertThat(deforestationRatesEntities).hasSize(0);
    }
}