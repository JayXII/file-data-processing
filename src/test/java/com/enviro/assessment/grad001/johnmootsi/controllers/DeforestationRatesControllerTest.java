package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.dto.DeforestationRatesDTO;
import com.enviro.assessment.grad001.johnmootsi.services.DeforestationRatesService;
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

@WebMvcTest(DeforestationRatesController.class)
class DeforestationRatesControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DeforestationRatesService deforestationRatesService;
    private DeforestationRatesDTO deforestationRatesDTO1;
    private DeforestationRatesDTO deforestationRatesDTO2;
    private final List<DeforestationRatesDTO> deforestationRatesDTOS = new ArrayList<>();

    @BeforeEach
    void setUp() {
        deforestationRatesDTO1 = new DeforestationRatesDTO(1L, "Test Name", "Test Description",
                "Test Region", "Test Rate", "Test Carbon",
                "Test Levels", new Date(2024, 7, 10));
        deforestationRatesDTO2 = new DeforestationRatesDTO(1L, "Test Name", "Test Description",
                "Test Region", "Test Rate", "Test Carbon",
                "Test Levels", new Date(2024, 7, 10));

        deforestationRatesDTOS.add(deforestationRatesDTO1);
        deforestationRatesDTOS.add(deforestationRatesDTO2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TestGetDeforestationRatesResultsById() throws Exception {
        when(deforestationRatesService.findDeforestationRatesById(1L)).thenReturn(deforestationRatesDTO1);
        this.mockMvc.perform(get("/api/v1/deforestation-rates/results/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void TestGetDeforestationRatesResultsByName() throws Exception {
        when(deforestationRatesService.findDeforestationRatesByName("land")).thenReturn(deforestationRatesDTOS);
        this.mockMvc.perform(get("/api/v1/deforestation-rates/results/name/land")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void TestGetDeforestationRatesResults() throws Exception {
        when(deforestationRatesService.findAllDeforestationRates()).thenReturn(deforestationRatesDTOS);
        this.mockMvc.perform(get("/api/v1/deforestation-rates/results")).andDo(print()).andExpect(status().isOk());
    }
}