package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.dto.LandUseDTO;
import com.enviro.assessment.grad001.johnmootsi.services.LandUseService;
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

@WebMvcTest(LandUseController.class)
class LandUseControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LandUseService landUseService;
    private LandUseDTO landUseDTO1;
    private LandUseDTO landUseDTO2;
    private final List<LandUseDTO> landUseDTOS = new ArrayList<>();

    @BeforeEach
    void setUp() {
        landUseDTO1 = new LandUseDTO(1L, "Test Land Use", "Test Description",
                "Test Location", "Test Type", new Date(2024, 7, 10));
        landUseDTO2 = new LandUseDTO(1L, "Test Land Use", "Test Description",
                "Test Location", "Test Type", new Date(2024, 7, 10));
        landUseDTOS.add(landUseDTO1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TestGetLandUseResultsById() throws Exception {
        when(landUseService.findLandUseById(1L)).thenReturn(landUseDTO1);
        this.mockMvc.perform(get("/api/v1/land-use/results/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void TestGetLandUseResultsByName() throws Exception {
        when(landUseService.findLandUseByName("land")).thenReturn(landUseDTOS);
        this.mockMvc.perform(get("/api/v1/land-use/results/name/land")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void TestGetLandUseResults() throws Exception {
        when(landUseService.findAllLandUse()).thenReturn(landUseDTOS);
        this.mockMvc.perform(get("/api/v1/land-use/results")).andDo(print()).andExpect(status().isOk());
    }
}