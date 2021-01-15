package com.javer.drink.app.project.service;

import com.javer.drink.app.project.web.dto.CategoryDto;

import java.util.Set;

public interface CategoryService {

    Set<CategoryDto> getUniqueCategory();
}
