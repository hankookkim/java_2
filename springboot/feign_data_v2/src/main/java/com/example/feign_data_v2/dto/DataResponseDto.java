package com.example.feign_data_v2.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class DataResponseDto {
    private Long id;
    private String name;
    private int value;
}