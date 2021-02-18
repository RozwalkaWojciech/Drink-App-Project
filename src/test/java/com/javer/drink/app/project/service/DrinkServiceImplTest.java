package com.javer.drink.app.project.service;
import com.javer.drink.app.project.model.Message;
import com.javer.drink.app.project.repository.MessageRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrinkServiceImplTest {

    @Autowired
    DrinkService drinkService;

    @Test
    void shouldReturnEmptyList(){
        //given
        int numberOfDrinks = 8;
        //when
        List<Integer> returnList = drinkService.countsPages(numberOfDrinks);
        //then
        assertTrue(returnList.isEmpty());
    }

}