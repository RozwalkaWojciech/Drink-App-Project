package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Message;
import com.javer.drink.app.project.web.dto.MessageDto;

public interface MessageService {

    void leaveMessage(Long id, String information);

    Message save(MessageDto messageDto);

    void update(Long id, String information);
}
