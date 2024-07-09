package com.enviro.assessment.grad001.johnmootsi.controllers;

import com.enviro.assessment.grad001.johnmootsi.dto.WaterQualityDTO;
import com.enviro.assessment.grad001.johnmootsi.services.WaterQualityService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WaterQualityController.class)
class WaterQualityControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WaterQualityService waterQualityService;
    private WaterQualityDTO waterQualityDTO1;
    private WaterQualityDTO waterQualityDTO2;
    private final List<WaterQualityDTO> waterQualityDTOS = new ArrayList<>();

    @BeforeEach
    void setUp() {
        waterQualityDTO1 = new WaterQualityDTO(1L, "Test Water Quality", "Test Description",
                "Test Parameter", "Test Sample Value", new Date(2024, 7, 9));
        waterQualityDTO2 = new WaterQualityDTO(2L, "Test Water Quality 2", "Test Description 2",
                "Test Parameter 3", "Test Sample Value 2", new Date(2024, 7, 9));
        waterQualityDTOS.add(waterQualityDTO1);
        waterQualityDTOS.add(waterQualityDTO2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TestGetWaterQualityResultsById() throws Exception {
        when(waterQualityService.findWaterQualityById(1L)).thenReturn(waterQualityDTO1);
        this.mockMvc.perform(get("/api/v1/water-quality/results/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetWaterQualityResultsByName() throws Exception {
        when(waterQualityService.findWaterQualityByName("water")).thenReturn(waterQualityDTOS);
        this.mockMvc.perform(get("/api/v1/water-quality/results/name/water")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetWaterQualityResults() throws Exception {
        when(waterQualityService.findAllWaterQuality()).thenReturn(waterQualityDTOS);
        this.mockMvc.perform(get("/api/v1/water-quality/results")).andDo(print()).andExpect(status().isOk());
    }
}