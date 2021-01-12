package com.javer.drink.app.project.web.controller;

import com.javer.drink.app.project.service.UserService;
import com.javer.drink.app.project.web.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/")
    public String home() {
        return "index2";
    }

    @GetMapping("/start")
    public String start() {
        userService.createAdmin();
        return "age-query";
    }

    @GetMapping("/adult-check")
    public String adultCheck(@RequestParam("age") String age) {
        if (age.equals("18+")) {
            return "redirect:home";
        } else {
            return "redirect:goodbye";
        }
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }

    @GetMapping("/navigation")
    public String navigation(@RequestParam("navigator") String navigator) {
        if (navigator.equals("Login")) {
            return "redirect:login";
        } else
            return "redirect:registration";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
