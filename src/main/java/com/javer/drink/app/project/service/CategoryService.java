package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Category;

import java.util.Optional;
import java.util.Set;

public interface CategoryService {

    Set<String> getUniqueCategoryNames();

    Category getByName(String name);

    Optional<Category> getById(Long id);

    void update(Long id, Category category);
}
