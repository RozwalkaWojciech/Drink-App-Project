package com.javer.drink.app.project.web.controller;

import com.javer.drink.app.project.service.CategoryService;
import com.javer.drink.app.project.service.DrinkService;
import com.javer.drink.app.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final DrinkService drinkService;
    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping("/user-view")
    public String showUserView(Model model) {
        return "user-view";
    }

}
