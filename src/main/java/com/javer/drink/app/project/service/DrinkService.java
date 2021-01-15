package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Drink;
import com.javer.drink.app.project.web.dto.DrinkDto;

import java.util.List;

public interface DrinkService {

    void save(DrinkDto drinkDto);

    void delete(String name);

    List<Drink> getAllDrinks();
}
