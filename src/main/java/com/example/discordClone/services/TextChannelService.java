package com.example.discordClone.services;

import com.example.discordClone.models.TextChannel;
import com.example.discordClone.repositories.TextChannelRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TextChannelService {

    @Autowired
    private TextChannelRepository textChannelRepository;

    public synchronized List<TextChannel> findAll() {
        return textChannelRepository.findAll();
    }

    public synchronized Optional<TextChannel> findById(Long id) {
        return textChannelRepository.findById(id);
    }

    public TextChannel save(TextChannel textChannel) {
        return textChannelRepository.save(textChannel);
    }

    public void deleteById(Long id) {
        textChannelRepository.deleteById(id);
    }

    public List<TextChannel> getTextChannelsByServerId(Long id) {

        return textChannelRepository.getTextChannelsByServerId(id);
    }
}