package com.javer.drink.app.project.service;

import com.javer.drink.app.project.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(UserRegistrationDto userRegistrationDto);
}
