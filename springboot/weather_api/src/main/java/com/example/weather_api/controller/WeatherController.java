package com.example.weather_api.controller;


import com.example.weather_api.dto.weather.WeatherResponse;
import com.example.weather_api.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherResponse getWeather() {
        return weatherService.getWeather();
    }
}