package com.example.discordClone.services;

import com.example.discordClone.models.ServerMember;
import com.example.discordClone.repositories.ServerMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerMemberService {

    @Autowired
    private ServerMemberRepository serverMemberRepository;

    public List<ServerMember> findAll() {
        return serverMemberRepository.findAll();
    }

    public Optional<ServerMember> findById(Long id) {
        return serverMemberRepository.findById(id);
    }

    public ServerMember save(ServerMember serverMember) {
        return serverMemberRepository.save(serverMember);
    }

    public void deleteById(Long id) {
        serverMemberRepository.deleteById(id);
    }
}