package com.javer.drink.app.project.file.mapper;

import com.javer.drink.app.project.file.parser.DrinkAPI;
import com.javer.drink.app.project.model.Ingredient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IngredientMapper {

    public List<Ingredient> mapIngredients(DrinkAPI drinkAPI) {
        List<Ingredient> ingredients = new ArrayList<>();
        drinkAPI.getIngredients().forEach((key, value) -> ingredients.add(Ingredient.builder()
                .name(key)
                .measure(value)
                .build()));
        return ingredients;
    }
}
