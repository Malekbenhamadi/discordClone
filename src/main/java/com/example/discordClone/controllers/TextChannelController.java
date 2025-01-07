package com.example.discordClone.controllers;

import com.example.discordClone.models.TextChannel;
import com.example.discordClone.services.TextChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/text-channels")
public class TextChannelController {

    @Autowired
    private TextChannelService textChannelService;

    @GetMapping
    public List<TextChannel> findAll() {
        return textChannelService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TextChannel> findById(@PathVariable Long id) {
        return textChannelService.findById(id);
    }

    @PostMapping
    public TextChannel save(@RequestBody TextChannel textChannel) {
        return textChannelService.save(textChannel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        textChannelService.deleteById(id);
    }

    @GetMapping("/server/{id}")
    public List<TextChannel> getTextChannelsByServerId(@PathVariable Long id) {
        return textChannelService.getTextChannelsByServerId(id);
    }
    
}