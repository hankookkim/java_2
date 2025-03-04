package com.example.basic_boardv1.model;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {

    private String userId;
    private String password;
    private String userName;        //도메인
}
