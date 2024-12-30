package com.example.discordClone.services;

import com.example.discordClone.models.Server;
import com.example.discordClone.repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public List<Server> findAll() {
        return serverRepository.findAll();
    }

    public Optional<Server> findById(Long id) {
        return serverRepository.findById(id);
    }

    public Server save(Server server) {
        return serverRepository.save(server);
    }

    public void deleteById(Long id) {
        serverRepository.deleteById(id);
    }
}