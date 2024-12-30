package com.example.discordClone.services;

import com.example.discordClone.models.VoiceChannel;
import com.example.discordClone.repositories.VoiceChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoiceChannelService {

    @Autowired
    private VoiceChannelRepository voiceChannelRepository;

    public List<VoiceChannel> findAll() {
        return voiceChannelRepository.findAll();
    }

    public Optional<VoiceChannel> findById(Long id) {
        return voiceChannelRepository.findById(id);
    }

    public VoiceChannel save(VoiceChannel voiceChannel) {
        return voiceChannelRepository.save(voiceChannel);
    }

    public void deleteById(Long id) {
        voiceChannelRepository.deleteById(id);
    }
}