package com.example.basic_boardv1.config;

import com.example.basic_boardv1.config.security.CustomAuthenticationFailureHandler;
import com.example.basic_boardv1.config.security.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(
                        "/static/**", "/css/**", "/js/**"
                );
    }

    @Bean
    public SecurityFilterChain filterChain
            (HttpSecurity http,
            CustomAuthenticationSuccessHandler successHandler,
             CustomAuthenticationFailureHandler failureHandler) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                // .csrf(AbstractHttpConfigurer::disable)는 Spring Security에서
                // CSRF 보호 기능을 비활성화하는 코드입니다. 이는 주로 API 서버나 토큰 인증을
                // 사용하는 애플리케이션에서 사용되며, 일반적인 웹 애플리케이션에서는 CSRF 보호를
                // 활성화하는 것이 더 안전합니다.
                .authorizeHttpRequests(
                        (authorizeRequests) -> authorizeRequests
                                .requestMatchers(
                                        new AntPathRequestMatcher("/join", "POST"),
                                        new AntPathRequestMatcher("/member/join", "GET"),
                                        new AntPathRequestMatcher("/member/login", "GET")
                                ).permitAll()
                                .anyRequest().authenticated()
                );

        http
                .formLogin(
                        formLogin -> formLogin
                                .loginPage("/member/login")
                                .loginProcessingUrl("/login")
                                .successHandler(successHandler)
                                .failureHandler(failureHandler)

                );

        return http.build();
    }

    @Bean    //@Bean: 메서드가 반환하는 객체를 Spring IoC 컨테이너에 빈으로 등록합니다.
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

