package com.example.discordClone.dto;

import lombok.Data;

@Data

public class ChatMessageDTO {
    private String content;
    private Long sender;
    private Long channelId;

    
}