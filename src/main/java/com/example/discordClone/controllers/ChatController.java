package com.example.discordClone.controllers;

import com.example.discordClone.dto.ChatMessageDTO;
import com.example.discordClone.models.Message;
import com.example.discordClone.models.User;
import com.example.discordClone.services.MessageService;
import com.example.discordClone.services.TextChannelService;
import com.example.discordClone.services.UserService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private TextChannelService textChannelService;

    @MessageMapping("/chat.sendMessage") // reception men aand client
   // @SendTo("/textChannel/channel/{channelId}") broadcasti l barcha clients bel facon l classique
    public void sendMessage(ChatMessageDTO chatMessage) {
        System.out.println(chatMessage);
        String destination = "/textChannel/channel/" + chatMessage.getChannelId(); // broadcasti l client specifique
        messagingTemplate.convertAndSend(destination, chatMessage);


        //persistence message
        Message message = new Message();
        message.setContent(chatMessage.getContent());
        userService.findById(chatMessage.getSender()).ifPresent(message::setSender);
        System.out.println("channel id: " + chatMessage.getChannelId());
        textChannelService.findById(chatMessage.getChannelId()).ifPresent(message::setChannel);
        messageService.save(message);



    }
}