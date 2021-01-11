package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.User;
import com.javer.drink.app.project.repository.UserRepository;
import com.javer.drink.app.project.web.dto.UserRegistrationDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, @Lazy BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserRegistrationDto userRegistrationDto) {
        User user = User.builder()
                .firstName(userRegistrationDto.getFirstName())
                .lastName(userRegistrationDto.getLastName())
                .email(userRegistrationDto.getEmail())
                .password(passwordEncoder.encode(userRegistrationDto.getPassword()))
                .build();
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
