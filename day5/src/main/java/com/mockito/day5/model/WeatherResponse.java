package com.mockito.day5.model;

public class WeatherResponse {
    private double rainfall;
    private String status;

    public WeatherResponse() {}
    public WeatherResponse(double rainfall, String status) {
        this.rainfall = rainfall;
        this.status = status;
    }

    public double getRainfall() {
        return rainfall;
    }

    public void setRainfall(double rainfall) {
        this.rainfall = rainfall;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
