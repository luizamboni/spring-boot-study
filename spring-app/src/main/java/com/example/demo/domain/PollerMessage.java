package com.example.demo.domain;


import org.springframework.lang.NonNull;

import java.util.Date;

public class PollerMessage {

    @NonNull
    private Date createdAt;
    private String text;
    private String sessionId;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "createdAt:" + createdAt + ",\n" +
                "text:" + text + ",\n" +
                "sessionId:" + sessionId + ",\n";

    }
}
