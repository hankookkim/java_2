package com.example.basic_board_v2.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDeleteRequestDTO {
    private String filePath;
}
