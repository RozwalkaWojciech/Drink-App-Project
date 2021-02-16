package com.javer.drink.app.project.file.service;

import com.javer.drink.app.project.file.mapper.DrinkMapper;
import com.javer.drink.app.project.file.parser.DrinkAPI;
import com.javer.drink.app.project.file.parser.ParserService;
import com.javer.drink.app.project.model.Drink;
import com.javer.drink.app.project.service.DrinkService;
import com.javer.drink.app.project.service.MessageService;
import com.javer.drink.app.project.web.dto.DrinkDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileParserService {

    private final ParserService parserService;
    private final DrinkService drinkService;
    private final MessageService messageService;
    private final DrinkMapper drinkMapper;

    public void parseDataToDatabase(File json) {
        List<DrinkAPI> drinkAPIList = parserService.parseFile(json);
        int size = drinkAPIList.size();
        int count = 0;
        for (DrinkAPI drinkAPI : drinkAPIList) {
            if (drinkService.getAllDrinks().stream().noneMatch(drink -> drink.getName().equals(drinkAPI.getName()))) {
                count++;
                Drink drink = Optional
                        .ofNullable(drinkService.get(drinkAPI.getCategory()))
                        .orElseGet(() -> drinkMapper.mapDrink(drinkAPI));

                drinkService.getAllDrinks().add(drinkMapper.mapDrink(drinkAPI));
                drinkService.save(DrinkDto.drinkToDto(drink));
            }
        }
        messageService.leaveMessage(1L, count + " items was parsed from " + size);
    }
}
