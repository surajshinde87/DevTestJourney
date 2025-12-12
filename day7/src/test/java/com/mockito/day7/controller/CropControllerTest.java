package com.mockito.day7.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.mockito.day7.service.CropService;

@WebMvcTest(CropController.class)
class CropControllerTest {

    @Autowired 
    MockMvc mockMvc;

    @MockitoBean    
    CropService cropService;

    @Test
    void testCropPredict() throws Exception {

        when(cropService.predictCrop(1L)).thenReturn("Wheat");

        mockMvc.perform(get("/api/crops/predict")
                    .param("fieldId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Wheat"));
    }
}
