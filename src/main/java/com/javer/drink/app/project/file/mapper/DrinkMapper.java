package com.javer.drink.app.project.file.mapper;

import com.javer.drink.app.project.file.parser.DrinkAPI;
import com.javer.drink.app.project.model.Drink;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DrinkMapper {

    private final IngredientMapper ingredientMapper;

    public Drink mapDrink(DrinkAPI drinkAPI) {
        return Drink.builder()
                .id(drinkAPI.getId())
                .name(drinkAPI.getName())
                .drinkType(drinkAPI.getDrinkType())
                .glassType(drinkAPI.getGlassType())
                .recipe(drinkAPI.getRecipe())
                .ingredientList(ingredientMapper.mapIngredients(drinkAPI))
                .modificationDate(drinkAPI.getModificationDate())
                .imageUrl(drinkAPI.getImageUrl())
                .category(drinkAPI.getCategory())
                .isCustom(false)
                .isApproved(true)
                .build();
    }
}
