package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Drink;
import com.javer.drink.app.project.web.dto.DrinkDto;

import java.util.List;
import java.util.Set;

public interface DrinkService {

    void save(DrinkDto drinkDto);

    void delete(String name);

    Drink get(String name);

    List<Drink> getAllDrinks();

    Set<String> getUniqueGlass();

    Set<String> getUniqueCategory();

    List<Integer> countsPages(Integer numberOfDrinks);

    List<Drink> getRequestDrinkList(Integer pageNumber, Integer numberOfDrinks);

}
