package com.example.demo.workers;

import com.example.demo.domain.PollerMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import com.example.demo.infrastructure.binders.MessagesProcessor;

@EnableBinding(value = { MessagesProcessor.class })
public class PollerMessages {


    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
    public void receive(PollerMessage message) {
        try {
            System.out.println(this.getClass().getName() + " -> processing");
            System.out.println( message.toString());
        } catch (Exception ex){
            System.out.println("error:" + ex.getMessage());
        }
    }
}
