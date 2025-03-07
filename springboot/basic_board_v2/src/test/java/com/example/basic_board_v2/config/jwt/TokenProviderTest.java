package com.example.basic_board_v2.config.jwt;

import com.example.basic_board_v2.model.Member;
import com.example.basic_board_v2.type.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest      //스프링 부트 어노테이션 써서 테스트 하고 싶으면 붙이기
class TokenProviderTest {


    @Autowired
    TokenProvider tokenProvider;

    @Test
    void 토큰생성_테스트(){
        //given
        Member member=Member.builder()
                .id(0L)
                .userId("test")
                .password("123456")
                .userName("test")
                .role(Role.ROLE_USER)
                .build();

        Duration duration = Duration.ofHours(1);

        //when
        String token= tokenProvider.generateToken(member, duration);

        //then
        Assertions.assertNotNull(token);
        System.out.println(token);
    }

}