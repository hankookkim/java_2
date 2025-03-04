package com.example.weather_api.dto.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
public class Header {
    private String resultCode;

    private String resultMsg;
}
