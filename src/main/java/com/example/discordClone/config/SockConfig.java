package com.example.discordClone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class SockConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/textChannel","/rtc-signaling-server");   // server yabaath message l client l destination tabda b /example ==> ysubcribi leha l client
        config.setApplicationDestinationPrefixes("/textMessage","/rtc-signal");// client yabaath message l destination tabda b /xx ==> ysendi leha l client
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
        registry.addEndpoint("/webrtc-signal").setAllowedOriginPatterns("*").withSockJS(); // Add endpoint for WebRTC signaling

    }
}

