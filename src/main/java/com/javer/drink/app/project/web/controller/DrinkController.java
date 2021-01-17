package com.javer.drink.app.project.web.controller;

import com.javer.drink.app.project.service.DrinkService;
import com.javer.drink.app.project.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class DrinkController {

    private final DrinkService drinkService;
    private final MessageService messageService;

    @GetMapping("/drink")
    public String drinkView(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("drink", drinkService.get(name));
        model.addAttribute("drinks", drinkService.getAllDrinks());
        return "drink-view";
    }

    @GetMapping("favourite-drink")
    public String favouriteDrink(@RequestParam(name = "name") String name, Model model) {
//        model.addAttribute("message", messageService.get(2L).getInformation());
        return "drink-view";
    }
}
