package com.example.operational_transform.controllers;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.operational_transform.dto.EditDTO;
import com.example.operational_transform.dto.Message;
import com.example.operational_transform.dto.OutputMessage;

@Controller
public class ChatController {
    
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send (Message message){
        return new OutputMessage(message.getFrom(),message.getBody(), LocalDateTime.now());
    }

    @MessageMapping("/editCollector")
    @SendTo("/topic/editDistributor")
    public EditDTO handelEdits (EditDTO incomingEdits){
        System.out.println(incomingEdits);
        return incomingEdits;
    }

    @MessageMapping("/syncCopyCollector")
    @SendTo("/topic/syncCopyDistributor")
    public String handelSync (String message){
        return message;
    }


}
