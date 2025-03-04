package com.example.feign_client.dto.weather;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.service.annotation.GetExchange;


@Getter
@Setter
@ToString
public class Item {
    private String baseDate;
    private String baseTime;
    private String category;
    private int nx;
    private int ny;
    private String obsrValue;
}
