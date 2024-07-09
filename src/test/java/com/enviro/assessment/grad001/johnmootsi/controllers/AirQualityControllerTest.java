package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.dto.AirQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.services.AirQualityService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(AirQualityController.class)
class AirQualityControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AirQualityService airQualityService;
    private AirQualityDTO airQualityDTO1;
    private AirQualityDTO airQualityDTO2;
    private final List<AirQualityDTO> airQualityDTOS = new ArrayList<>();


    @BeforeEach
    void setUp() {
        airQualityDTO1 = new AirQualityDTO(1L, "Test Air Quality", "Test Description",
                "Test Pollutant", "Test Concentration", new Date(2024, 7, 9));
        airQualityDTO2 = new AirQualityDTO(2L, "Test Air Quality 2", "Test Description 2",
                "Test Pollutant 2", "Test Concentration 2", new Date(2024, 7, 9));
        airQualityDTOS.add(airQualityDTO1);
        airQualityDTOS.add(airQualityDTO2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetAirQualityResultsById() throws Exception {
        when(airQualityService.findAirQualityById(1L)).thenReturn(airQualityDTO1);
        this.mockMvc.perform(get("/api/v1/air-quality/results/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAirQualityResultsByName() throws Exception {
        when(airQualityService.findAirQualityByName("Test air")).thenReturn(airQualityDTOS);
        this.mockMvc.perform(get("/api/v1/air-quality/results/name/air")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAirQualityResults() throws Exception {
        when(airQualityService.findAllAirQuality()).thenReturn(airQualityDTOS);
        this.mockMvc.perform(get("/api/v1/air-quality/results")).andDo(print()).andExpect(status().isOk());
    }
}