package com.example.operational_transform.dto;

import java.time.LocalDateTime;

public class OutputMessage {
    String from;
    String body;
    LocalDateTime date;

    public OutputMessage(String from, String body, LocalDateTime date){
        this.body = body;
        this.from = from;
        this.date = date;
    }

    public String getBody() {
        return body;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public String getFrom() {
        return from;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    
}