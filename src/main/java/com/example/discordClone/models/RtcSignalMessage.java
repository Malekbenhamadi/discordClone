package com.example.discordClone.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RtcSignalMessage {
    private String type; // offer answer candidate hangup   
    private String sdp;
    private String candidate; // ice candidate
    private String sdpMid;
    private Integer sdpMLineIndex;
}