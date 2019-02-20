package com.example.web.domain;


import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.Date;

@Data
@Builder
public class ChatMessage {



    @NonNull
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
