package com.example.weatherApp.model;

import java.util.List;

public class WeatherResponse {
    public Main main;
    public List<Weather> weather;
    public String name; // city name

    public static class Main {
        public double temp;
    }

    public static class Weather {
        public String main;     // e.g., Rain, Clear
        public String description;
        public String icon; 
    }
}
