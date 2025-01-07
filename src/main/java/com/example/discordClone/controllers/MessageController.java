package com.example.discordClone.controllers;

import com.example.discordClone.models.Message;
import com.example.discordClone.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> findAll() {
        return messageService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> findById(@PathVariable Long id) {
        return messageService.findById(id);
    }

    @PostMapping
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        messageService.deleteById(id);
    }

    @GetMapping("/text-channel/{textChannelId}")
    public List<Message> getMessagesByTextChannel(@PathVariable Long textChannelId) {
        return messageService.getMessagesByChannelId(textChannelId);
    }
    
}