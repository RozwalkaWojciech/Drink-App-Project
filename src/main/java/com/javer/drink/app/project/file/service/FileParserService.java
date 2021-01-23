package com.javer.drink.app.project.file.service;

import com.javer.drink.app.project.file.mapper.CategoryMapper;
import com.javer.drink.app.project.file.mapper.DrinkMapper;
import com.javer.drink.app.project.file.parser.ParserService;
import com.javer.drink.app.project.model.Category;
import com.javer.drink.app.project.file.parser.DrinkAPI;
import com.javer.drink.app.project.service.CategoryService;
import com.javer.drink.app.project.service.DrinkService;
import com.javer.drink.app.project.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@RequestScope
@Transactional
public class FileParserService {

    private final ParserService parserService;
    private final DrinkService drinkService;
    private final MessageService messageService;
    private final DrinkMapper drinkMapper;
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    public void parseDataToDatabase(File json) {
        List<DrinkAPI> drinkAPIList = parserService.parseFile(json);
        int size = drinkAPIList.size();
        int count = 0;
        for (DrinkAPI drinkAPI : drinkAPIList) {
            if (drinkService.getAllDrinks().stream().noneMatch(drink -> drink.getName().equals(drinkAPI.getName()))) {
                count++;
                Category category = Optional
                        .ofNullable(categoryService.getByName(drinkAPI.getCategory()))
                        .orElseGet(() -> categoryMapper.mapCategory(drinkAPI));
                category.getDrinkList().add(drinkMapper.mapDrink(drinkAPI, category));
                categoryService.save(category);
            }
        }
        messageService.leaveMessage(1L, count + " items was parsed from " + size);
    }
}
