package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Category;
import com.javer.drink.app.project.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Set<String> getUniqueCategoryNames() {
        return categoryRepository.findAll().stream().map(Category::getName).collect(Collectors.toSet());
    }

    @Override
    public Category getByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void update(Long id, Category category) {
        Optional<Category> categoryById = getById(id);
        if (categoryById.isPresent()) {
            categoryById.get().setName(category.getName());
            categoryRepository.save(categoryById.get());
        }
    }
}
