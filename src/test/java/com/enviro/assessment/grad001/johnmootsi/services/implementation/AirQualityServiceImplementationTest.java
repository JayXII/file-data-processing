package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.utility.converters.AirQualityDTOAndEntityConverter;
import com.enviro.assessment.grad001.johnmootsi.dto.AirQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.AirQualityEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.AirQualityRepository;
import com.enviro.assessment.grad001.johnmootsi.services.AirQualityService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AirQualityServiceImplementationTest {
    // Mock the repository / autocloseable to close all resources/ service layer that we're testing
    // Add dependencies

    @Mock
    private AirQualityRepository airQualityRepository;
    private AirQualityService airQualityService;
    AutoCloseable autoCloseable;
    private AirQualityEntity airQualityEntity;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        airQualityService = new AirQualityServiceImplementation(airQualityRepository);
        airQualityEntity = new AirQualityEntity();
        airQualityEntity.setId(1L);
        airQualityEntity.setName("Test Air Quality");
        airQualityEntity.setDescription("Test Air Quality Description");
        airQualityEntity.setPollutant("Test Air Quality Pollutant");
        airQualityEntity.setConcentration("Test Air Quality Concentration");
        airQualityEntity.setMeasurementDate(new Date(2024, Calendar.JULY, 5));
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testFindAirQualityByIdFound() {
        mock(AirQualityRepository.class);
        mock(AirQualityEntity.class);

        when(airQualityRepository.findById(1L)).thenReturn(Optional.ofNullable(airQualityEntity));
        assertThat(airQualityService.findAirQualityById(1L).getName()).isEqualTo("Test Air Quality");
        assertThat(airQualityService.findAirQualityById(1L).getDescription()).isEqualTo("Test Air Quality Description");
        assertThat(airQualityService.findAirQualityById(1L).getPollutant()).isEqualTo("Test Air Quality Pollutant");
        assertThat(airQualityService.findAirQualityById(1L).getConcentration()).isEqualTo("Test Air Quality Concentration");
        assertThat(airQualityService.findAirQualityById(1L).getMeasurementDate()).isEqualTo(new Date(2024, Calendar.JULY, 5));
        assertThat(airQualityService.findAirQualityById(1L)).isInstanceOf(AirQualityDTO.class);
    }

    @Test
    void testFindAirQualityByIdNotFound() {
        mock(AirQualityRepository.class);
        mock(AirQualityEntity.class);

        when(airQualityRepository.findById(1L)).thenReturn(Optional.ofNullable(airQualityEntity));
        assertThat(airQualityService.findAirQualityById(10L)).isNull();
    }

    @Test
    void testFindAirQualityByNameFound() {
        mock(AirQualityRepository.class);
        mock(AirQualityEntity.class);

        when(airQualityRepository.findByNameContainingIgnoreCase("Test Air")).thenReturn(new ArrayList<>(Collections.singletonList(airQualityEntity)));
        assertThat(airQualityService.findAirQualityByName("Test Air").get(0).getName()).isEqualTo("Test Air Quality");
        assertThat(airQualityService.findAirQualityByName("Test Air").get(0).getDescription()).isEqualTo("Test Air Quality Description");
        assertThat(airQualityService.findAirQualityByName("Test Air")).hasSize(1);
    }

    @Test
    void testFindAirQualityByNameNotFound() {
        mock(AirQualityRepository.class);
        mock(AirQualityEntity.class);

        when(airQualityRepository.findByNameContainingIgnoreCase("Test Air")).thenReturn(new ArrayList<>(Collections.singletonList(airQualityEntity)));
        assertThat(airQualityService.findAirQualityByName("Foo")).isEqualTo(Collections.emptyList());
        assertThat(airQualityService.findAirQualityByName("foo")).hasSize(0);
    }

    @Test
    void testFindAllAirQualityFound() {
        mock(AirQualityRepository.class);
        mock(AirQualityEntity.class);

        when(airQualityRepository.findAll()).thenReturn(new ArrayList<>(Collections.singletonList(airQualityEntity)));
        assertThat(airQualityService.findAllAirQuality()).hasSize(1);
        assertThat(airQualityService.findAllAirQuality().get(0).getName()).isEqualTo("Test Air Quality");
    }

    @Test
    void testFindAllAirQualityNotFound() {
        mock(AirQualityRepository.class);
        mock(AirQualityEntity.class);

        when(airQualityRepository.findAll()).thenReturn(new ArrayList<>(Collections.emptyList()));
        assertThat(airQualityService.findAllAirQuality()).hasSize(0);
        assertThat(airQualityService.findAllAirQuality().isEmpty()).isTrue();
    }

    @Test
    void testSave() {
        mock(AirQualityRepository.class);
        mock(AirQualityEntity.class);

        when(airQualityRepository.save(airQualityEntity)).thenReturn(airQualityEntity);
        assertThat(airQualityService.save(AirQualityDTOAndEntityConverter.convertToDTO(airQualityEntity))).isEqualTo("Success");
    }
}