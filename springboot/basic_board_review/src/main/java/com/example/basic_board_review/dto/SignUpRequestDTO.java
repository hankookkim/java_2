package com.example.basic_board_review.dto;

import com.example.basic_board_review.model.Member;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@ToString
public class SignUpRequestDTO {
    private String userID;
    private String password;
    private String userName;

    public Member toMember(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return Member.builder()
                .userId(userID)
                .password(bCryptPasswordEncoder.encode(password))
                .userName(userName)
                .build();

    }
}
