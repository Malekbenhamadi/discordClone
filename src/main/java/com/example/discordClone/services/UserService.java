package com.example.discordClone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.discordClone.models.User;
import com.example.discordClone.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    public synchronized List<User> findAll() {
        return userRepository.findAll();
    }

    public synchronized Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByUsername(String username) {
        String jpql = "SELECT u FROM User u WHERE u.username = :attribute";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("attribute", username);
        return query.getResultList().stream().findFirst();
    }
}