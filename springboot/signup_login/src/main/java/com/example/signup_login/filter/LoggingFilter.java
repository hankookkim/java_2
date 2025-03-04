package com.example.signup_login.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //필터 초기화(필요시)
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        //**필수 (HTTP에 맞게 구현)

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;  //다운캐스팅

        //-->요청 정보 로깅
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("Request Method: " + request.getMethod());


        //필터체인 :계속해서 다음 필터 또는 서블릿으로 전달
        filterChain.doFilter(servletRequest, servletResponse);

        //<--응답 상태 코드 로깅
        System.out.println("Response Status:"+response.getStatus());
    }

    @Override
    public void destroy() {
        //필터 종료시 처리(필요시)
    }
}
