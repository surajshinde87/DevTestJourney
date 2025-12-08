package test.java.com.junit.day3.weather;

import main.java.com.junit.day3.weather.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {

    private WeatherService weatherService;

    @BeforeEach
    void init() {
        weatherService = new WeatherService();
    }

    @Test
    void testLowRainfall(){
        assertEquals("Irrigation Required", weatherService.getIrrigationAdvice(30));
    }

    @Test
    void testModerateRainfall(){
        assertEquals("No Irrigation Needed", weatherService.getIrrigationAdvice(80));
    }

    @Test
    void testHighRainfall(){
        assertEquals("Risk of Flood - Take Precautions", weatherService.getIrrigationAdvice(150));
    }
    
}