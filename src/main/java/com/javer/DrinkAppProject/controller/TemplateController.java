package com.javer.DrinkAppProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }
}
