package com.javer.drink.app.project.mapper;

import com.javer.drink.app.project.model.Ingredient;
import com.javer.drink.app.project.parser.DrinkAPI;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IngredientMapper {

    public List<Ingredient> mapIngredients(DrinkAPI drinkAPI) {

        List<Ingredient> ingredients = new ArrayList<>();

        drinkAPI.getIngredients().entrySet().forEach(i -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(i.getKey());
            ingredient.setMeasure(i.getValue());
            ingredients.add(ingredient);
        });
        return ingredients;
    }
}
