package com.javer.drink.app.project.web.dto;

import com.javer.drink.app.project.model.Ingredient;
import lombok.Data;

@Data
public class IngredientDto {

    private Long id;
    private String name;
    private String measure;

    public static IngredientDto ingredientToDto(Ingredient ingredient) {
        IngredientDto ingredientDTO = new IngredientDto();
        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setMeasure(ingredient.getMeasure());
        return ingredientDTO;
    }

    public static Ingredient dtoToIngredient(IngredientDto ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDTO.getName());
        ingredient.setMeasure(ingredientDTO.getMeasure());
        return ingredient;
    }
}
