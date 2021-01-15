package com.javer.drink.app.project.service;

import com.javer.drink.app.project.repository.CategoryRepository;
import com.javer.drink.app.project.web.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Set<CategoryDto> getUniqueCategory() {
        return;
    }
}
