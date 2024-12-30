package com.example.discordClone.services;

import com.example.discordClone.models.Message;
import com.example.discordClone.repositories.MessageRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    

    public synchronized List<Message> findAll() {
        return new ArrayList<>(messageRepository.findAll());
    }

    public synchronized Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }

    public  Message save(Message message) {
        return messageRepository.save(message);
    }

    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }
}