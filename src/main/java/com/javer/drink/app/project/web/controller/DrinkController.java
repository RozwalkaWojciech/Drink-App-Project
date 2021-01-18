package com.javer.drink.app.project.web.controller;

import com.javer.drink.app.project.model.User;
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
        model.addAttribute("drink", drinkService.get(name));
        model.addAttribute("drinks", drinkService.getAllDrinks());
        model.addAttribute("message", messageService.get(1L).getInformation());
        model.addAttribute("favourite", drinkService.get("Melya"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.get(authentication.getName());



        return "drink-view";
    }

    @GetMapping("favourite-drink")
    public String favouriteDrink(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("message", messageService.get(1L).getInformation());
        return "redirect:drink?name=" + name;
    }
}
