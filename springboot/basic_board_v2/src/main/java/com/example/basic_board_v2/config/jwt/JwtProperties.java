package com.example.basic_board_v2.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("jwt")  //yml 최상위 키, 첫번째방식 @Value, 두번째 @ConfigurationProperties yml정보 자바 코트에서 쓰고싶어서 가져오는법
public class JwtProperties {
    private String issuer;
    private String secretKey;

}
