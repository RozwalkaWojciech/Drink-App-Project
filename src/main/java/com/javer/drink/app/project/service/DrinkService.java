package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Drink;
import com.javer.drink.app.project.web.dto.DrinkDto;

public interface DrinkService {

    Drink save(DrinkDto drinkDto);

    void delete(String name);
}
