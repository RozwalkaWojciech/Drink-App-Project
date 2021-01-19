package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Message;
import com.javer.drink.app.project.web.dto.MessageDto;

import java.util.Optional;

public interface MessageService {

    Optional<Message> get(Long id);

    void leaveMessage(Long id, String information);

    Message save(MessageDto messageDto);

    void update(Long id, String information);
}
