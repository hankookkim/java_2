package com.example.basic_boardv1.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

public class SignInRequestDTO {
    private String userId;
    private String password;
}
