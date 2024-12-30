package com.example.discordClone.repositories;

import com.example.discordClone.models.ServerMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerMemberRepository extends JpaRepository<ServerMember, Long> {
}
