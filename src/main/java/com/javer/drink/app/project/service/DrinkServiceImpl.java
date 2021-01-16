package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Category;
import com.javer.drink.app.project.model.Drink;
import com.javer.drink.app.project.repository.DrinkRepository;
import com.javer.drink.app.project.web.dto.DrinkDto;
import com.javer.drink.app.project.web.dto.IngredientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    private final MessageService messageService;

    @Override
    public void save(DrinkDto drinkDto) {
        String drinkDtoName = drinkDto.getName();
        if (drinkRepository.findByName(drinkDtoName) != null) {
            messageService.leaveMessage(1L, "Drink called '" + drinkDtoName + "' already exists!");
        } else {
            messageService.leaveMessage(1L, "Drink called '" + drinkDtoName + "' has been added!");
            drinkRepository.save(Drink.builder()
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
    }

    @Override
    public void delete(String name) {
        if (drinkRepository.findByName(name) == null) {
            messageService.leaveMessage(1L, "Drink called '" + name + "' does not exist!");
        } else {
            messageService.leaveMessage(1L, "Drink called '" + name + "' has been deleted!");
            drinkRepository.delete(drinkRepository.findByName(name));
        }
    }

    @Override
    public Drink get(String name) {
        return drinkRepository.findByName(name);
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    @Override
    public Set<String> getUniqueGlass() {
        return drinkRepository.findAll().stream().map(Drink::getGlassType).collect(Collectors.toSet());
    }
}
