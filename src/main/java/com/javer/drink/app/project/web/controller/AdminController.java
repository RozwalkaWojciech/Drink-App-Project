package com.javer.drink.app.project.web.controller;

import com.javer.drink.app.project.service.DrinkService;
import com.javer.drink.app.project.service.MessageService;
import com.javer.drink.app.project.web.dto.CategoryDto;
import com.javer.drink.app.project.web.dto.DrinkDto;
import com.javer.drink.app.project.web.dto.IngredientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final DrinkService drinkService;

    private final MessageService messageService;

    @GetMapping("/admin-panel")
    public String showAdminPanel(Model model) {
        model.addAttribute("drinks",drinkService.getAllDrinks());
        return "admin-panel";
    }

    @PostMapping("/save-drink")
    public String saveDrink(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "recipe") String recipe,
            @RequestParam(name = "drinkType") String drinkType,
            @RequestParam(name = "glassType") String glassType,
            @RequestParam(name = "imageUrl") String imageUrl,
            @RequestParam(name = "category") String category,
            @RequestParam(name = "ingredient") String[] ingredient,
            @RequestParam(name = "measure") String[] measure,
            Model model
    ) {

        List<IngredientDto> ingredientList = new ArrayList<>();

        for (int ing = 0; ing < ingredient.length; ing++) {
            IngredientDto ingredientDto = new IngredientDto();
            ingredientDto.setName(ingredient[ing]);
            ingredientDto.setMeasure(measure[ing]);
            ingredientList.add(ingredientDto);
        }

        DrinkDto drinkDto = new DrinkDto();
        drinkDto.setName(name);
        drinkDto.setIsCustom(true);
        drinkDto.setIsApproved(true);
        drinkDto.setRecipe(recipe);
        drinkDto.setDrinkType(drinkType);
        drinkDto.setGlassType(glassType);
        drinkDto.setImageUrl(imageUrl);
        drinkDto.setCategory(CategoryDto.builder().name(category).build());
        drinkDto.setIngredientList(ingredientList);

        drinkService.save(drinkDto);
        model.addAttribute("message", messageService.get(1L).getInformation());

        return "admin-panel";
    }

    @PostMapping("/delete-drink")
    public String deleteDrink(
            @RequestParam(name = "name") String name,
            Model model
    ) {
        drinkService.delete(name);
        model.addAttribute("message", messageService.get(1L).getInformation());
        return "admin-panel";
    }
}
