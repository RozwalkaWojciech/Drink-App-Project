package com.javer.drink.app.project.web.controller;

import com.javer.drink.app.project.service.DrinkService;
import com.javer.drink.app.project.web.dto.CategoryDto;
import com.javer.drink.app.project.web.dto.DrinkDto;
import com.javer.drink.app.project.web.dto.IngredientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin-panel")
@RequiredArgsConstructor
public class AdminController {

    private final DrinkService drinkService;

    @GetMapping
    public String showAdminPanel() {
        return "admin-panel";
    }

    @PostMapping
    public String saveDrink(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "recipe") String recipe,
            @RequestParam(name = "drinkType") String drinkType,
            @RequestParam(name = "glassType") String glassType,
            @RequestParam(name = "imageUrl") String imageUrl,
            @RequestParam(name = "category") String category,
            @RequestParam(name = "ingredient") String[] ingredient,
            @RequestParam(name = "measure") String[] measure
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

        return "admin-panel";
    }
}
