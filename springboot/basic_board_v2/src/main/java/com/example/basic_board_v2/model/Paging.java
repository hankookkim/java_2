package com.example.basic_board_v2.model;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Paging {
    private int offset;

    private int size;
}
