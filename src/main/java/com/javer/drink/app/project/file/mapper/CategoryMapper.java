package com.javer.drink.app.project.file.mapper;

import com.javer.drink.app.project.model.Category;
import com.javer.drink.app.project.file.parser.DrinkAPI;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category mapCategory(DrinkAPI drinkAPI) {
        Category category = new Category();
        category.setName(drinkAPI.getCategory());
        return category;
    }
}
