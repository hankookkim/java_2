package com.example.weather_api.dto.weather;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    private Header header;
    private Body body;
}
