package com.javer.drink.app.project.web.controller;

import com.javer.drink.app.project.service.DrinkService;
import com.javer.drink.app.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final DrinkService drinkService;
    private final UserService userService;

    @GetMapping("/user-view")
    public String showUserView(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("drinks", drinkService.getAllDrinks());
        model.addAttribute("user", userService.get(authentication.getName()));
        return "user-view";
    }

}
