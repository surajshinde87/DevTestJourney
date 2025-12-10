package com.mockito.day5.service;

import com.mockito.day5.client.WeatherClient;
import com.mockito.day5.model.WeatherResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private WeatherClient weatherClient;

    @InjectMocks
    private WeatherService weatherService;

    @BeforeEach
    void setup() {
        weatherClient = new WeatherClient(restTemplate, "http://fake-api.com");
        weatherService = new WeatherService(weatherClient);
    }

    @Test
    void testLowRainfall() {
        WeatherResponse resp = new WeatherResponse(20, "OK");

        when(restTemplate.getForEntity(
                "http://fake-api.com/weather?city=Pune",
                WeatherResponse.class))
                .thenReturn(ResponseEntity.ok(resp));

        String result = weatherService.irrigationAdvice("Pune");

        assertEquals("Irrigation Required", result);
        verify(restTemplate).getForEntity(anyString(), eq(WeatherResponse.class));
    }

    @Test
    void testHighRainfallFlood() {
        WeatherResponse resp = new WeatherResponse(150, "OK");

        when(restTemplate.getForEntity(anyString(), eq(WeatherResponse.class)))
                .thenReturn(ResponseEntity.ok(resp));

        assertEquals("Risk of Flood", weatherService.irrigationAdvice("Mumbai"));
    }

    @Test
    void testApiError() {
        when(restTemplate.getForEntity(anyString(), eq(WeatherResponse.class)))
                .thenThrow(new ResourceAccessException("timeout"));

        assertThrows(ResourceAccessException.class,
                () -> weatherService.irrigationAdvice("Delhi"));
    }

    @Test
    void testArgumentCaptorForURL() {
        WeatherResponse resp = new WeatherResponse(80, "OK");
        when(restTemplate.getForEntity(anyString(), eq(WeatherResponse.class)))
                .thenReturn(ResponseEntity.ok(resp));

        weatherService.irrigationAdvice("Nagpur");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(restTemplate).getForEntity(captor.capture(), eq(WeatherResponse.class));

        String capturedUrl = captor.getValue();
        assertTrue(capturedUrl.contains("Nagpur"));
    }
}
