package main.java.com.junit.day3.weather;

public class WeatherService {

    public String getIrrigationAdvice(double rainfall) {

        if (rainfall < 50)
            return "Irrigation Required";

        if (rainfall >= 50 && rainfall <= 120)
            return "No Irrigation Needed";

        return "Risk of Flood - Take Precautions";
    }

}
