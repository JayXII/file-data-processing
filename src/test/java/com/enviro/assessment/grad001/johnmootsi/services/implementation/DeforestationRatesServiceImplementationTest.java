package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.dto.DeforestationRatesDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.DeforestationRatesEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.DeforestationRatesRepository;
import com.enviro.assessment.grad001.johnmootsi.services.DeforestationRatesService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeforestationRatesServiceImplementationTest {

    private DeforestationRatesService deforestationRatesService;
    @Mock
    private DeforestationRatesRepository deforestationRatesRepository;
    private DeforestationRatesEntity deforestationRatesEntity;
    private DeforestationRatesDTO deforestationRatesDTO;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        deforestationRatesService = new DeforestationRatesServiceImplementation(deforestationRatesRepository);

        deforestationRatesEntity = new DeforestationRatesEntity();
        deforestationRatesEntity.setId(1L);
        deforestationRatesEntity.setName("Test Deforestation Rates");
        deforestationRatesEntity.setDescription("Test Description");
        deforestationRatesEntity.setDeforestationRate("Test Deforestation Rate");
        deforestationRatesEntity.setSoilNutrientLevels("Test Soil Nutrient Levels");
        deforestationRatesEntity.setRegion("Test Region");
        deforestationRatesEntity.setSoilOrganicCarbonRate("Test Soil Organic Carbon");
        deforestationRatesEntity.setSamplingDate(new Date(2024, Calendar.JULY, 6));

        deforestationRatesDTO = new DeforestationRatesDTO();
        deforestationRatesDTO.setId(1L);
        deforestationRatesDTO.setName("Test Deforestation Rates");
        deforestationRatesDTO.setDescription("Test Description");
        deforestationRatesDTO.setDeforestationRate("Test Deforestation Rate");
        deforestationRatesDTO.setSoilNutrientLevels("Test Soil Nutrient Levels");
        deforestationRatesDTO.setRegion("Test Region");
        deforestationRatesDTO.setSoilOrganicCarbonRate("Test Soil Organic Carbon");
        deforestationRatesDTO.setSamplingDate(new Date(2024, Calendar.JULY, 6));
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testFindDeforestationRatesByIdFound() {
        mock(DeforestationRatesRepository.class);
        mock(DeforestationRatesEntity.class);
        mock(DeforestationRatesDTO.class);

        when(deforestationRatesRepository.findById(1L)).thenReturn(Optional.ofNullable(deforestationRatesEntity));
        assertThat(deforestationRatesService.findDeforestationRatesById(1L)).isEqualTo(deforestationRatesDTO);
        assertThat(deforestationRatesService.findDeforestationRatesById(1L).getName()).isEqualTo("Test Deforestation Rates");
        assertThat(deforestationRatesService.findDeforestationRatesById(1L).getDescription()).isEqualTo("Test Description");
    }

    @Test
    void testFindDeforestationRatesByIdNotFound() {
        mock(DeforestationRatesRepository.class);
        mock(DeforestationRatesEntity.class);

        when(deforestationRatesRepository.findById(1L)).thenReturn(Optional.ofNullable(deforestationRatesEntity));
        assertThat(deforestationRatesService.findDeforestationRatesById(10L)).isNull();
    }

    @Test
    void testFindDeforestationRatesByNameFound() {
        mock(DeforestationRatesRepository.class);
        mock(DeforestationRatesEntity.class);
        mock(DeforestationRatesDTO.class);

        when(deforestationRatesRepository.findByNameContainingIgnoreCase("test Deforestation")).thenReturn(new ArrayList<>(Collections.singleton(deforestationRatesEntity)));
        assertThat(deforestationRatesService.findDeforestationRatesByName("test Deforestation").get(0)).isEqualTo(deforestationRatesDTO);
        assertThat(deforestationRatesService.findDeforestationRatesByName("test Deforestation").get(0).getName()).isEqualTo("Test Deforestation Rates");
    }

    @Test
    void testFindDeforestationRatesByNameNotFound() {
        mock(DeforestationRatesRepository.class);
        mock(DeforestationRatesEntity.class);
        mock(DeforestationRatesDTO.class);

        when(deforestationRatesRepository.findByNameContainingIgnoreCase("test Deforestation")).thenReturn(new ArrayList<>(Collections.singleton(deforestationRatesEntity)));
        assertThat(deforestationRatesService.findDeforestationRatesByName("fizz")).isEqualTo(Collections.emptyList());
        assertThat(deforestationRatesService.findDeforestationRatesByName("buzz")).hasSize(0);
    }

    @Test
    void testFindAllDeforestationRatesFound() {
        mock(DeforestationRatesRepository.class);
        mock(DeforestationRatesEntity.class);
        mock(DeforestationRatesDTO.class);

        when(deforestationRatesRepository.findAll()).thenReturn(Collections.singletonList(deforestationRatesEntity));
        assertThat(deforestationRatesService.findAllDeforestationRates().get(0)).isEqualTo(deforestationRatesDTO);
        assertThat(deforestationRatesService.findAllDeforestationRates().get(0).getName()).isEqualTo("Test Deforestation Rates");
    }

    @Test
    void testFindAllDeforestationRatesNotFound() {
        mock(DeforestationRatesRepository.class);
        mock(DeforestationRatesEntity.class);

        when(deforestationRatesRepository.findAll()).thenReturn(Collections.emptyList());
        assertThat(deforestationRatesService.findAllDeforestationRates()).isEqualTo(Collections.emptyList());
        assertThat(deforestationRatesService.findAllDeforestationRates()).hasSize(0);
    }

    @Test
    void save() {
        mock(DeforestationRatesRepository.class);
        mock(DeforestationRatesEntity.class);
        mock(DeforestationRatesDTO.class);


        when(deforestationRatesRepository.save(deforestationRatesEntity)).thenReturn(deforestationRatesEntity);
        assertThat(deforestationRatesService.save(deforestationRatesDTO)).isEqualTo("Success");
    }
}