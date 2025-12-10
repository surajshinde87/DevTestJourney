package com.mockito.day5.service;
import com.mockito.day5.client.WeatherClient;
import com.mockito.day5.model.WeatherResponse;

public class WeatherService {

    private final WeatherClient client;

    public WeatherService(WeatherClient client) {
        this.client = client;
    }

    public String irrigationAdvice(String city) {
        WeatherResponse resp = client.fetchWeather(city);

        if (resp.getRainfall() < 50)
            return "Irrigation Required";

        if (resp.getRainfall() <= 120)
            return "No Irrigation Needed";

        return "Risk of Flood";
    }

}