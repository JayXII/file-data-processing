package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.dto.WaterQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.WaterQualityEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.WaterQualityRepository;
import com.enviro.assessment.grad001.johnmootsi.services.WaterQualityService;
import com.enviro.assessment.grad001.johnmootsi.utility.converters.WaterQualityDTOAndEntityConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WaterQualityServiceImplementationTest {
    // Mock the repository / autocloseable to close all resources/ service layer that we're testing
    // Add dependencies
    private WaterQualityService waterQualityService;
    @Mock
    private WaterQualityRepository waterQualityRepository;
    private WaterQualityEntity waterQualityEntity;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        waterQualityService = new WaterQualityServiceImplementation(waterQualityRepository);
        waterQualityEntity = new WaterQualityEntity();
        waterQualityEntity.setId(1L);
        waterQualityEntity.setName("Test Water Quality");
        waterQualityEntity.setDescription("Test Description");
        waterQualityEntity.setSampleValue("Test Value");
        waterQualityEntity.setParameter("Test Parameter");
        waterQualityEntity.setSamplingDate(new Date(2024, Calendar.JULY, 5));

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testFindWaterQualityByIdFound() {
        mock(WaterQualityRepository.class);
        mock(WaterQualityEntity.class);

        when(waterQualityRepository.findById(1L)).thenReturn(Optional.ofNullable(waterQualityEntity));
        assertThat(waterQualityService.findWaterQualityById(1L).getName()).isEqualTo("Test Water Quality");
        assertThat(waterQualityService.findWaterQualityById(1L).getId()).isEqualTo(1L);
        assertThat(waterQualityService.findWaterQualityById(1L)).isInstanceOf(WaterQualityDTO.class);
    }

    @Test
    void testFindWaterQualityByIdNotFound() {
        mock(WaterQualityRepository.class);
        mock(WaterQualityEntity.class);

        when(waterQualityRepository.findById(1L)).thenReturn(Optional.ofNullable(waterQualityEntity));
        assertThat(waterQualityService.findWaterQualityById(10L)).isNull();
    }

    @Test
    void testFindWaterQualityByNameFound() {
        mock(WaterQualityRepository.class);
        mock(WaterQualityEntity.class);

        when(waterQualityRepository.findByNameContainingIgnoreCase("tesT water")).thenReturn(new ArrayList<>(Collections.singleton(waterQualityEntity)));
        assertThat(waterQualityService.findWaterQualityByName("tesT water").get(0).getName()).isEqualTo("Test Water Quality");
        assertThat(waterQualityService.findWaterQualityByName("tesT water").get(0).getId()).isEqualTo(1L);
        assertThat(waterQualityService.findWaterQualityByName("tesT water").get(0)).isInstanceOf(WaterQualityDTO.class);
    }

    @Test
    void testFindWaterQualityByNameNotFound() {
        mock(WaterQualityRepository.class);
        mock(WaterQualityEntity.class);

        when(waterQualityRepository.findByNameContainingIgnoreCase("tesT water")).thenReturn(new ArrayList<>(Collections.singleton(waterQualityEntity)));
        assertThat(waterQualityService.findWaterQualityByName("air")).hasSize(0);
        assertThat(waterQualityService.findWaterQualityByName("air")).isEmpty();
    }

    @Test
    void testFindAllWaterQualityFound() {
        mock(WaterQualityRepository.class);
        mock(WaterQualityEntity.class);

        when(waterQualityRepository.findAll()).thenReturn(List.of(waterQualityEntity));
        assertThat(waterQualityService.findAllWaterQuality()).hasSize(1);
        assertThat(waterQualityService.findAllWaterQuality().get(0).getName()).isEqualTo("Test Water Quality");
        assertThat(waterQualityService.findAllWaterQuality().get(0).getId()).isEqualTo(1L);
        assertThat(waterQualityService.findAllWaterQuality().get(0)).isInstanceOf(WaterQualityDTO.class);
    }

    @Test
    void testFindAllWaterQualityNotFound() {
        mock(WaterQualityRepository.class);
        mock(WaterQualityEntity.class);

        when(waterQualityRepository.findAll()).thenReturn(List.of());
        assertThat(waterQualityService.findAllWaterQuality()).hasSize(0);
        assertThat(waterQualityService.findAllWaterQuality().isEmpty()).isTrue();
    }

    @Test
    void TestSave() {
        mock(WaterQualityRepository.class);
        mock(WaterQualityEntity.class);

        when(waterQualityRepository.save(waterQualityEntity)).thenReturn(waterQualityEntity);
        assertThat(waterQualityService.save(WaterQualityDTOAndEntityConverter.convertToDTO(waterQualityEntity))).isEqualTo("Success");
    }
}