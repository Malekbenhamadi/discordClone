package com.example.discordClone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.discordClone.dto.ChatMessageDTO;
import com.example.discordClone.models.Message;

@Service
public class KafkaConsumer {

    @Autowired
    private  MessageService messageService;
    @Autowired
    private  UserService userService;
    @Autowired
    private  TextChannelService textChannelService;

    @KafkaListener(topics = "textChannel-topic", groupId = "text-channel-group")
    public void consume(ChatMessageDTO record) {
        System.out.println("Received Message: " + record);

        //persisti l message
        Message message = new Message();
        message.setContent(record.getContent());
        userService.findById(record.getSender()).ifPresent(message::setSender);
        System.out.println("channel id: " + record.getChannelId());
        textChannelService.findById(record.getChannelId()).ifPresent(message::setChannel);
        messageService.save(message);

        
    }
}

