package com.enviro.assessment.grad001.johnmootsi.services.implementation;

import com.enviro.assessment.grad001.johnmootsi.dto.LandUseDTO;
import com.enviro.assessment.grad001.johnmootsi.entities.LandUseEntity;
import com.enviro.assessment.grad001.johnmootsi.repository.LandUseRepository;
import com.enviro.assessment.grad001.johnmootsi.services.LandUseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class LandUseServiceImplementationTest {

    private LandUseService landUseService;
    @Mock
    private LandUseRepository landUseRepository;
    private LandUseEntity landUseEntity;
    private LandUseDTO landUseDTO;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        landUseService = new LandUseServiceImplementation(landUseRepository);

        landUseEntity = new LandUseEntity();
        landUseEntity.setId(1L);
        landUseEntity.setName("Test Land Use");
        landUseEntity.setDescription("Test Description");
        landUseEntity.setLandUseType("Test Type");
        landUseEntity.setLocation("Test Location");
        landUseEntity.setSamplingDate(new Date(2024, Calendar.JULY, 6));

        landUseDTO = new LandUseDTO();
        landUseDTO.setId(1L);
        landUseDTO.setName("Test Land Use");
        landUseDTO.setDescription("Test Description");
        landUseDTO.setLandUseType("Test Type");
        landUseDTO.setLocation("Test Location");
        landUseDTO.setSamplingDate(new Date(2024, Calendar.JULY, 6));

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testFindLandUseByIdFound() {
        mock(LandUseEntity.class);
        mock(LandUseRepository.class);

        when(landUseRepository.findById(1L)).thenReturn(Optional.ofNullable(landUseEntity));
        assertThat(landUseService.findLandUseById(1L)).isEqualTo(landUseDTO);
        assertThat(landUseService.findLandUseById(1L).getName()).isEqualTo("Test Land Use");
    }

    @Test
    void testFindLandUseByIdNotFound() {
        mock(LandUseEntity.class);
        mock(LandUseRepository.class);

        when(landUseRepository.findById(1L)).thenReturn(Optional.ofNullable(landUseEntity));
        assertThat(landUseService.findLandUseById(10L)).isEqualTo(null);
    }

    @Test
    void testFindLandUseByNameFound() {
        mock(LandUseEntity.class);
        mock(LandUseRepository.class);

        when(landUseRepository.findByNameContainingIgnoreCase("tesT land")).thenReturn(new ArrayList<>(Collections.singleton(landUseEntity)));
        assertThat(landUseService.findLandUseByName("tesT land").get(0)).isEqualTo(landUseDTO);
        assertThat(landUseService.findLandUseByName("tesT land")).hasSize(1);
        assertThat(landUseService.findLandUseByName("tesT land").get(0).getName()).isEqualTo("Test Land Use");
    }

    @Test
    void testFindLandUseByNameNotFound() {
        mock(LandUseEntity.class);
        mock(LandUseRepository.class);

        when(landUseRepository.findByNameContainingIgnoreCase("tesT land")).thenReturn(Collections.emptyList());
        assertThat(landUseService.findLandUseByName("fizz")).isEqualTo(Collections.emptyList());
        assertThat(landUseService.findLandUseByName("buzz")).hasSize(0);
    }

    @Test
    void testFindAllLandUseFound() {
        mock(LandUseEntity.class);
        mock(LandUseRepository.class);

        when(landUseRepository.findAll()).thenReturn(Collections.singletonList(landUseEntity));
        assertThat(landUseService.findAllLandUse()).hasSize(1);
        assertThat(landUseService.findAllLandUse().get(0).getName()).isEqualTo("Test Land Use");
        assertThat(landUseService.findAllLandUse().get(0).getDescription()).isEqualTo("Test Description");
        assertThat(landUseService.findAllLandUse().get(0).getLandUseType()).isEqualTo("Test Type");
        assertThat(landUseService.findAllLandUse().get(0).getLocation()).isEqualTo("Test Location");
        assertThat(landUseService.findAllLandUse().get(0)).isEqualTo(landUseDTO);
    }

    @Test
    void testFindAllLandUseNotFound() {
        mock(LandUseEntity.class);
        mock(LandUseRepository.class);

        when(landUseRepository.findAll()).thenReturn(Collections.emptyList());
        assertThat(landUseService.findAllLandUse()).hasSize(0);
        assertThat(landUseService.findAllLandUse()).isEqualTo(Collections.emptyList());
    }

    @Test
    void testSave() {
        mock(LandUseRepository.class);
        mock(LandUseEntity.class);
        mock(LandUseDTO.class);

        when(landUseRepository.save(landUseEntity)).thenReturn(landUseEntity);
        assertThat(landUseService.save(landUseDTO)).isEqualTo("Success");
    }
}