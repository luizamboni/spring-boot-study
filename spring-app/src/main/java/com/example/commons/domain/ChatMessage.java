package com.example.commons.domain;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@Entity
public class ChatMessage {

    @Id
    @GeneratedValue
    private Long id;

    private Date createdAt;
    private String text;
    private String sessionId;


    @Override
    public String toString() {
        return "createdAt:" + createdAt + ",\n" +
                "text:" + text + ",\n" +
                "sessionId:" + sessionId + ",\n";

    }
}
