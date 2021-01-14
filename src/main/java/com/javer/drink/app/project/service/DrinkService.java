package com.javer.drink.app.project.service;

import com.javer.drink.app.project.web.dto.DrinkDto;

public interface DrinkService {

    void save(DrinkDto drinkDto);

    void delete(String name);
}
