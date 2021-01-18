package com.javer.drink.app.project.web.controller;

import com.javer.drink.app.project.service.DrinkService;
import com.javer.drink.app.project.service.MessageService;
import com.javer.drink.app.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class DrinkController {

    private final DrinkService drinkService;
    private final MessageService messageService;
    private final UserService userService;

    @GetMapping("/drink")
    public String drinkView(@RequestParam(name = "name") String name, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("drink", drinkService.get(name));
        model.addAttribute("drinks", drinkService.getAllDrinks());
        model.addAttribute("message", messageService.get(1L).getInformation());
        model.addAttribute("favourite", userService.isFavourite(name, authentication.getName()));
        return "drink-view";
    }

    @GetMapping("favourite-drink")
    public String favouriteDrink(@RequestParam(name = "name") String name) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.manageFavourite(name, authentication.getName());
        return "redirect:drink?name=" + name;
    }
}
