package com.example.basic_board_review.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInResponseDTO {
    private boolean success;
    private String userId;
    private String userName;
}
