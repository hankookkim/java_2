package com.example.signup_login.controller;

import com.example.signup_login.dto.MemberDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller

public class CookieController {


    private List<MemberDto> Members=new ArrayList<>();



    @GetMapping("/login-cookie")
    public String login(){
        return "login-cookie";
    }


    @PostMapping("/login-cookie")
    public String loginExc(@RequestParam String username,
                               HttpServletResponse response,
                               Model model) {
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(7*24*60*60);
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
        model.addAttribute("username", username);
        model.addAttribute("message","가입이 완료되었습니다");
        return "result-cookie";
    }










    @GetMapping("/set-cookie")
    public String setCookie() {
        return "set-cookie";
    }



    @PostMapping("/set-cookie")
    public String setCookieExc(@RequestParam String username,
                               HttpServletResponse response,
                                Model model) {
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(7*24*60*60);
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
        model.addAttribute("username", username);
        model.addAttribute("message","쿠키가 설정되었습니다");
        return "result-cookie";
    }

    @GetMapping("/get-cookie")
    public String getCookieExc(
            HttpServletRequest request,
            Model model) {
        Cookie[] cookies = request.getCookies();
        String username = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;

                }
            }
        }
        if(username!=null){
            model.addAttribute("username",username);
            model.addAttribute("message","쿠키에서 사용자 정보를 읽었습니다");
        }else{
            model.addAttribute("message","쿠기가 존재하지 않습니다");
        }
        return "result-cookie";
    }

    @GetMapping("/delete-cookie")
    public String deleteCookieExc(
            HttpServletResponse response,
            Model model

    ){
        Cookie cookie = new Cookie ("username","");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("message","쿠키가 삭제되었습니다");
        return "result-cookie";
    }
}