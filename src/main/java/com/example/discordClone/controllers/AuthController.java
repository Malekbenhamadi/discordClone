package com.example.discordClone.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.discordClone.dto.UserDTO;
import com.example.discordClone.models.User;
import com.example.discordClone.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    private final String SECRET_KEY = "70MwmnoYF5DRuJn17RktKBHXt6WVN5tMJ5+8CKYmONU=";
                


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserDTO user) {
        Optional<User> foundUser = userService.findByUsername(user.getUsername());
        if (foundUser.isPresent()) {
            User userToCheck = foundUser.get();
            if (BCrypt.checkpw(user.getPassword(), userToCheck.getPassword())) {              
                // Generate JWT
                String token = Jwts.builder()
                        .setSubject(userToCheck.getUsername())
                        // .claim("role", userToCheck.getRole()) // Add custom claims if needed
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours validity
                        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                        .compact();

                // Return token
                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid password"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid username"));
        }
    }

}
