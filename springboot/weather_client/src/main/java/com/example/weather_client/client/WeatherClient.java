package com.example.weather_client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="weatherClient", url="${feign-data.url}")
public interface WeatherClient{


@GetMapping("/weather/forecast")
public String getWeatherForecast(@RequestParam String baseDate,
                                 @RequestParam String baseTime,
                                 @RequestParam int nx,
                                 @RequestParam int ny);

}








