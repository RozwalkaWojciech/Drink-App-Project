package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Drink;
import com.javer.drink.app.project.model.User;
import com.javer.drink.app.project.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto userRegistrationDto);

    User get(String email);

    void manageFavourite(String drinkName, String userEmail);

    void addFavourite(String drinkName, String userEmail);

    void deleteFavourite(String drinkName, String userEmail);

    Optional<Drink> isFavourite(String drinkName, String userEmail);

    void createAdmin();
}
