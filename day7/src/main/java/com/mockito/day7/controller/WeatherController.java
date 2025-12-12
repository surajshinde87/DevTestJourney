package com.mockito.day7.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockito.day7.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService service;
    public WeatherController(WeatherService service) { this.service = service; }

    @GetMapping("/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city) {
        return ResponseEntity.ok(service.getWeather(city));
    }
}
