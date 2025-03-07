package com.example.basic_board_v2.model;

import com.example.basic_board_v2.type.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private Role role;
}
