package com.example.feign_client.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DataRequestDto {
    private String name;

    private int value;
}
