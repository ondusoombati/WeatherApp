package com.example.weatherApp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.weatherApp.model.WeatherResponse;
import com.example.weatherApp.service.WeatherService;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam(defaultValue = "Nairobi") String city, Model model) {
        try {
            WeatherResponse weather = weatherService.getWeather(city, apiKey).block();
            String advice = getClothingAdvice(weather.main.temp, weather.weather.get(0).main);
            model.addAttribute("city", weather.name);
            model.addAttribute("conditionIcon", weather.weather.get(0).icon);
            model.addAttribute("temp", weather.main.temp);
            model.addAttribute("condition", weather.weather.get(0).main);
            model.addAttribute("advice", advice);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "weather";
    }

    private String getClothingAdvice(double temp, String condition) {
        if (temp < 15) return "Wear something warm (jacket or sweater).";
        if (condition.equalsIgnoreCase("Rain")) return "Carry an umbrella or wear a raincoat.";
        if (temp > 28) return "Wear light clothes and stay hydrated.";
        return "Dress comfortably for the day.";
    }
}
