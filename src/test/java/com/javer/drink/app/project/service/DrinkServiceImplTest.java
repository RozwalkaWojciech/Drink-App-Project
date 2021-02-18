package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Drink;
import com.javer.drink.app.project.repository.DrinkRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DrinkServiceImplTest {

    @Autowired
    DrinkService drinkService;
    @Autowired
    DrinkRepository drinkRepository;

    Drink drink = new Drink();

    @AfterEach
    void after() {
        drinkRepository.delete(drink);
    }

    @Test
    void shouldReturnEmptyList() {
        //given
        int drinksPerPage = 8;
        //when
        List<Integer> returnList = drinkService.countsPages(drinksPerPage);
        //then
        assertTrue(returnList.isEmpty());
    }

    @Test
    void shouldReturnOnlyOneNumberPage() {
        //given
        int drinksPerPage = 8;
        drinkRepository.save(drink);
        //when
        List<Integer> returnList = drinkService.countsPages(drinksPerPage);
        //then
        assertEquals(1, returnList.size());
    }
}