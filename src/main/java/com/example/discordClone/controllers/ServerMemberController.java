package com.example.discordClone.controllers;

import com.example.discordClone.models.ServerMember;
import com.example.discordClone.services.ServerMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/server-members")
public class ServerMemberController {

    @Autowired
    private ServerMemberService serverMemberService;

    @GetMapping
    public List<ServerMember> findAll() {
        return serverMemberService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ServerMember> findById(@PathVariable Long id) {
        return serverMemberService.findById(id);
    }

    @PostMapping
    public ServerMember save(@RequestBody ServerMember serverMember) {
        return serverMemberService.save(serverMember);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        serverMemberService.deleteById(id);
    }
}