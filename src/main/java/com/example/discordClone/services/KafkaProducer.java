package com.example.discordClone.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.discordClone.dto.ChatMessageDTO;

@Service
public class KafkaProducer {
    
    private final KafkaTemplate<String, ChatMessageDTO> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, ChatMessageDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, ChatMessageDTO message) {
        kafkaTemplate.send(topic, key, message);
    }
}
