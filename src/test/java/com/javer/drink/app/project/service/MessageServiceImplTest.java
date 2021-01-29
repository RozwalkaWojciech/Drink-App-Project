package com.javer.drink.app.project.service;

import com.javer.drink.app.project.model.Message;
import com.javer.drink.app.project.repository.MessageRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageServiceImplTest {

    @Autowired
    MessageService messageService;
    @Autowired
    MessageRepository messageRepository;

    private Message message;

    @BeforeEach
    void init() {
        message  = messageRepository.save(new Message(1L, "Test"));
    }

    @AfterEach
    void after(){
        messageRepository.delete(message);
    }

    @Test
    void shouldLeaveMessageById() {
        //given
        Long testId = 2L;
        String testMessage = "Test2";
        //when
        messageService.leaveMessage(testId,testMessage);
        //then
        assertThat(messageService.get(testId)).isPresent();
        assertThat(messageService.get(testId).orElseThrow().getInformation()).isEqualTo("Test2");
    }

    @Test
    void shouldUpdateLeaveMessage(){
        //given
        Long id = 1L;
        String updateMessage = "Update";
        //when
        messageService.leaveMessage(id, updateMessage);
        //then
        assertThat(messageService.get(id).orElseThrow().getInformation()).isEqualTo("Update");
    }

    @Test
    void shouldReturnEmptyMessage(){
        //given
        Long id = 3L;
        //when
        //then
        assertThat(messageService.get(id)).isNotPresent();
    }
}