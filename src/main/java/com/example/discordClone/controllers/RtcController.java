package com.example.discordClone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.discordClone.models.RtcSignalMessage;

@Controller
public class RtcController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
    @MessageMapping("/signal") // reception
    public void handleSignal(RtcSignalMessage signalMessage,SimpMessageHeaderAccessor headerAccessor) {
        System.out.println(" rtc signal messages "+signalMessage);
        String destination = "/rtc-signaling-server";
        messagingTemplate.convertAndSend(destination, signalMessage);

         
    }

}
