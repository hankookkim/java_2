package com.example.weather_api.dto.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

public class Items {
    private List<Item> item;
}

