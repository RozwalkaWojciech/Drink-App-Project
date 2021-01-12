package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Category;
import com.javer.drink.app.project.model.Drink;
import com.javer.drink.app.project.repository.DrinkRepository;
import com.javer.drink.app.project.web.dto.DrinkDto;
import com.javer.drink.app.project.web.dto.IngredientDto;
import com.javer.drink.app.project.web.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    private final MessageService messageService;

    @Override
    public Drink save(DrinkDto drinkDto) {
        messageService.save(MessageDto.builder()
                .information("BLA")
                .build());
        messageService.leaveMessage(1L, "SAVE METHOD");
        return drinkRepository.save(Drink.builder()
                .name(drinkDto.getName())
                .isCustom(true)
                .isApproved(true)
                .recipe(drinkDto.getRecipe())
                .drinkType(drinkDto.getDrinkType())
                .glassType(drinkDto.getGlassType())
                .modificationDate(String.valueOf(LocalDate.now()))
                .imageUrl(drinkDto.getImageUrl())
                .category(Category.builder()
                        .name(drinkDto.getCategory().getName())
                        .build())
                .ingredientList(drinkDto.getIngredientList().stream().map(IngredientDto::dtoToIngredient).collect(Collectors.toList()))
                .build());
    }

    @Override
    public void delete(String name) {
        drinkRepository.delete(drinkRepository.findByName(name));
    }
}
