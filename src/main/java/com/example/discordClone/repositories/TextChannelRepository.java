package com.example.discordClone.repositories;

import com.example.discordClone.models.TextChannel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TextChannelRepository extends JpaRepository<TextChannel, Long> {

    @Query("SELECT t FROM TextChannel t WHERE t.server.id = ?1")
    List<TextChannel> getTextChannelsByServerId(Long id);
}
