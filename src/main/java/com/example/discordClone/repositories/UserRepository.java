package com.example.discordClone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.discordClone.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}