package com.example.discordClone.repositories;

import com.example.discordClone.models.Message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.channel.id = ?1")
    List<Message> getMessagesByChannelId(Long id);
}
