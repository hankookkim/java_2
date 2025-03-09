package com.example.essentials.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class LoggingFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        System.out.println("Request URI"+request.getRequestURI());
        System.out.println("Request Method"+request.getMethod());

        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Reponse Status"+response.getStatus());
    }

    @Override
    public void destroy() {

    }
}
