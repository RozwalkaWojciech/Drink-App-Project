package com.javer.drink.app.project.file;

import com.javer.drink.app.project.mapper.CategoryMapper;
import com.javer.drink.app.project.mapper.DrinkMapper;
import com.javer.drink.app.project.model.Category;
import com.javer.drink.app.project.parser.DrinkAPI;
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
@RequestScope
@Transactional
@RequiredArgsConstructor
public class FileParserService {

    private final ParserService parserService;
    private final DrinkService drinkService;
    private final MessageService messageService;
    private final DrinkMapper drinkMapper;
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    public Object parseDataToDatabase(File json) {
        List<DrinkAPI> drinkAPIList = (List<DrinkAPI>) parserService.parseFile(json);
        int size = drinkAPIList.size();
        int count = 0;
        for (DrinkAPI drinkAPI : drinkAPIList) {
            if (drinkService.getAllDrinks().stream().noneMatch(drink -> drink.getName().equals(drinkAPI.getName()))) {
                count++;
                Category category = Optional
                        .ofNullable(categoryService.getByName(drinkAPI.getCategory()))
                        .orElseGet(() -> categoryMapper.mapCategory(drinkAPI));
                category.getDrinkList().add(drinkMapper.mapDrink(drinkAPI, category));
                categoryService.update(category);
            }
        }
        messageService.leaveMessage(1L, count + " items was parsed from " + size);
        return new Object();
    }
}
