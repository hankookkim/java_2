package com.example.feign_client.controller;

import com.example.feign_client.dto.weather.WeatherResponse;
import com.example.feign_client.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherApiController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
public WeatherResponse getWeather() {
        return weatherService.getWeather();
    }
}
