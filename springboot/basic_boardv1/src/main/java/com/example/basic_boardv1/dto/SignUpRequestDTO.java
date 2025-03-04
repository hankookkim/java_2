package com.example.basic_boardv1.dto;


import com.example.basic_boardv1.model.Member;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@ToString
public class SignUpRequestDTO {

    private String userId;
    private String password;
    private String userName;

    Mem
    public Member toMember(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return Member.builder()
                .userId(userId)
                .password(bCryptPasswordEncoder.encode(password))
                .userName(userName)
                .build();
    }
//BCryptPasswordEncoder: 비밀번호를 안전하게 암호화하기 위해 사용됩니다.

}
