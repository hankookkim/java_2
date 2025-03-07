package com.example.basic_board_v2.dto;


import com.example.basic_board_v2.type.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponseDTO {
    private Long id;
    private String userName;
    private String userId;
    private Role role;
}
