package com.example.basic_board_v2.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SignInRequestDTO {
    private String userName;
    private String password;
}
