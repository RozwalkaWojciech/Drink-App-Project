package com.javer.drink.app.project.web.dto;

import com.javer.drink.app.project.model.Category;
import lombok.Data;

@Data
public class CategoryDto {

    private Long id;
    private String name;

    public static CategoryDto categoryToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    public static Category dtoToCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }
}
