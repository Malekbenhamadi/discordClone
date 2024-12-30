package com.example.discordClone.controllers;

import com.example.discordClone.models.Server;
import com.example.discordClone.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping
    public List<Server> findAll() {
        return serverService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Server> findById(@PathVariable Long id) {
        return serverService.findById(id);
    }

    @PostMapping
    public Server save(@RequestBody Server server) {
        return serverService.save(server);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        serverService.deleteById(id);
    }
}