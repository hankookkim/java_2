package com.example.essentials.config;


import com.example.essentials.filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LoggingFilter> filterRegistrationBean() {
        FilterRegistrationBean<LoggingFilter> filterRegistration = new FilterRegistrationBean<>();

        filterRegistration.setFilter(new LoggingFilter());  //사용할 필터 등록
        filterRegistration.addUrlPatterns("/api/*");    //필터 적용 url 패턴 설정
        filterRegistration.setOrder(1);                 // 필터 실행 순서지정

        return filterRegistration;

    }
}
