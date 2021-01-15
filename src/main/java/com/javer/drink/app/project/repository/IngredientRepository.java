package com.javer.drink.app.project.repository;

import com.javer.drink.app.project.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
