package com.example.feign_data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DataResponseDto {
    private Long id;
    private String name;
    private int value;

}
