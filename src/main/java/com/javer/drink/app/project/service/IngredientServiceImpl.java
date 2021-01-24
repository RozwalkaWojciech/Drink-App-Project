package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Ingredient;
import com.javer.drink.app.project.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public Set<String> getUniqueIngredientNames() {
        return ingredientRepository.findAll().stream().map(Ingredient::getName).collect(Collectors.toSet());
    }
}
