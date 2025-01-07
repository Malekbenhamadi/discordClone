package com.example.discordClone.controllers;

import com.example.discordClone.dto.ChatMessageDTO;
import com.example.discordClone.models.Message;
import com.example.discordClone.services.MessageService;
import com.example.discordClone.services.TextChannelService;
import com.example.discordClone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private KafkaTemplate<String, ChatMessageDTO> kafkaTemplate;

    
    private static final String TOPIC = "textChannel-topic";


    @MessageMapping("/chat.sendMessage") // reception men aand client
   // @SendTo("/textChannel/channel/{channelId}") broadcasti l barcha clients bel facon l classique
    public void sendMessage(ChatMessageDTO chatMessage) {
        String destination = "/textChannel/channel/" + chatMessage.getChannelId(); // broadcasti l client specifique
        messagingTemplate.convertAndSend(destination, chatMessage);
        kafkaTemplate.send(TOPIC, chatMessage);


    }
}