package com.mockito.day5.client;

import com.mockito.day5.model.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class WeatherClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public WeatherClient(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public WeatherResponse fetchWeather(String city) {
        String url = baseUrl + "/weather?city=" + city;

        ResponseEntity<WeatherResponse> entity = restTemplate.getForEntity(url, WeatherResponse.class);

        if (!entity.getStatusCode().is2xxSuccessful() || entity.getBody() == null) {
            throw new RuntimeException("Failed to fetch weather data");
        }

        return entity.getBody();

    }

}