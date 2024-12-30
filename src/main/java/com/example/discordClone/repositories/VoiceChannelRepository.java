package com.example.discordClone.repositories;

import com.example.discordClone.models.VoiceChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoiceChannelRepository extends JpaRepository<VoiceChannel, Long> {
}
