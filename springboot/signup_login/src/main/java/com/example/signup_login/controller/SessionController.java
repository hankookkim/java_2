package com.example.signup_login.controller;



import com.example.signup_login.dto.MemberDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SessionController {

private List<MemberDto> members=new ArrayList<>();


    @GetMapping("/signup")
    public String signup(MemberDto member,
                         Model model,
                         HttpSession session) {

        String username=(String)session.getAttribute("username");
        String id =(String)session.getAttribute("userId");
        String password =(String)session.getAttribute("userPassword");
        if(session==null){
            System.out.println("null");

        }
        if (username != null && password != null && id != null) {
            model.addAttribute("username", username);
            members.add(member);
            System.out.println(members);
        }
        return "signup";
    }



    @PostMapping("/signup")
    public String signupExc(@RequestParam String username,
                            @RequestParam String userId,
                            @RequestParam String userPassword,
                            HttpSession session){

        session.setAttribute("username", username);
        session.setAttribute("userId", userId);
        session.setAttribute("userPassword", userPassword);
        return "redirect:signup";

    }




    @GetMapping("/login")
    public String login(
            HttpSession session,
            Model model
    ) {
        String username =(String)session.getAttribute("username");
        String id =(String)session.getAttribute("userId");
        String password =(String)session.getAttribute("userPassword");
        if (username != null && password != null && id != null) {
            model.addAttribute("username", username);

        }
                return "login";
    }
    @PostMapping("/login")
    public String loginExc(@RequestParam String username,
                           @RequestParam String userId,
                           @RequestParam String userPassword,
                           HttpSession session) {
        session.setAttribute("username", username);
        session.setAttribute("userId", userId);
        session.setAttribute("userPassword", userPassword);
        return "redirect:login";
    }


    @GetMapping("/logout")
    public String logoutExc(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }



}

