package com.example.discordClone.controllers;

import com.example.discordClone.models.VoiceChannel;
import com.example.discordClone.services.VoiceChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/voice-channels")
public class VoiceChannelController {

    @Autowired
    private VoiceChannelService voiceChannelService;

    @GetMapping
    public List<VoiceChannel> findAll() {
        return voiceChannelService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<VoiceChannel> findById(@PathVariable Long id) {
        return voiceChannelService.findById(id);
    }

    @PostMapping
    public VoiceChannel save(@RequestBody VoiceChannel voiceChannel) {
        return voiceChannelService.save(voiceChannel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        voiceChannelService.deleteById(id);
    }
}