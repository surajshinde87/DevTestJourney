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

import com.mockito.day7.service.WeatherService;

@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired 
    MockMvc mockMvc;

    @MockitoBean  
    WeatherService service;

    @Test
    void testWeather() throws Exception {

        when(service.getWeather("pune")).thenReturn("Sunny");

        mockMvc.perform(get("/api/weather/pune"))
                .andExpect(status().isOk())
                .andExpect(content().string("Sunny"));
    }
}
