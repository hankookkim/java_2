package com.example.essentials.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CookieController {

    @GetMapping("/set-cookie")
    public String setCookie() {
        return "set-cookie";
    }


    @PostMapping("/set-cookie")//회원가입
    public String setCookieExc(@RequestParam String username,
                               HttpServletResponse response,
                               Model model) {
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        response.addCookie(cookie);

        model.addAttribute("message", "You have successfully set cookie");
        model.addAttribute("username", username);
        return "result-cookie";
    }

    @GetMapping("/get-cookie") //로그인
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
            if (username != null) {
                model.addAttribute("username", username);
                model.addAttribute("message", "쿠키에서 사용자 정보를 읽었습니다");
            } else {
                model.addAttribute("message", "쿠키가 존재하지 않습니다");
            }
            return "result-cookie";
        }

    }

