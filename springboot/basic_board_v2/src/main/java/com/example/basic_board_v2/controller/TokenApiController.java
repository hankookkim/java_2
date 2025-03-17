package com.example.basic_board_v2.controller;

import com.example.basic_board_v2.config.jwt.TokenProvider;
import com.example.basic_board_v2.dto.SignInResponseDTO;
import com.example.basic_board_v2.model.Member;
import com.example.basic_board_v2.util.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class TokenApiController {

    private final TokenProvider tokenProvider;

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String refreshToken = CookieUtil.getCookieValue(request, "refreshToken");

        if (refreshToken != null && tokenProvider.validToken(refreshToken) == 1) {
            Member member = tokenProvider.getTokenDetails(refreshToken);

            String newAccessToken  = tokenProvider.generateToken(member, Duration.ofHours(2));
            String newRefreshToken = tokenProvider.generateToken(member, Duration.ofDays(2));

            CookieUtil.addCookie(response, "refreshToken", newRefreshToken, 7 * 24 * 60 * 60);

            response.setHeader(HttpHeaders.AUTHORIZATION, newAccessToken);

            return ResponseEntity.ok(
                    SignInResponseDTO.builder()
                            .token(newAccessToken)
                            .build()
            );
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Refresh Token이 유효하지 않습니다.");
        }
    }

}





//    @RestController
//    @RequiredArgsConstructor
//    public class TokenApiController {
//
//        private final TokenService tokenService;
//
//        @PostMapping("/refresh-token")
//        public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response) {
//            // 1. 클라이언트로부터 Refresh Token을 가져옵니다.
//            String refreshToken = CookieUtil.getCookieValue(request, "refreshToken");
//
//            // 2. TokenService의 refreshToken 메서드를 호출하여 새로운 토큰을 처리합니다.
//            return tokenService.refreshToken(refreshToken, response);
//        }
//    }


