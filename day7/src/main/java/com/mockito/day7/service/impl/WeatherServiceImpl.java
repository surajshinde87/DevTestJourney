package com.mockito.day7.service.impl;

import org.springframework.stereotype.Service;
import com.mockito.day7.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public String getWeather(String city) {
        return "Sunny weather in " + city;
    }
}
