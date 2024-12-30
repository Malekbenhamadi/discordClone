package com.example.discordClone.repositories;

import com.example.discordClone.models.TextChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextChannelRepository extends JpaRepository<TextChannel, Long> {
}
