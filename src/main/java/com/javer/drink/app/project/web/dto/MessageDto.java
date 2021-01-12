package com.javer.drink.app.project.web.dto;

import com.javer.drink.app.project.model.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private Long id;
    private String information;

    public static MessageDto messageToDto(Message message) {
        return new MessageDto(message.getId() ,message.getInformation());
    }

    public static Message dtoToMessage(MessageDto messageDto) {
        return new Message(messageDto.getId(), messageDto.getInformation());
    }
}
