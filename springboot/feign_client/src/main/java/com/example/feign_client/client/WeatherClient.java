package com.example.feign_client.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="WeatherClient", url = "${weather.api.url}")
public interface WeatherClient {
}
