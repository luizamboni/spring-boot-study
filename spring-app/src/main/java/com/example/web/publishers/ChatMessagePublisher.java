package com.example.web.publishers;

import com.example.web.infrastructure.binders.MessagesSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;


@EnableBinding(MessagesSource.class)
public class ChatMessagePublisher {

    @Autowired
    private MessagesSource messagePublisher;

    public Boolean publish(Object msg) {
        Boolean sended = messagePublisher.pollerOut().send(
                MessageBuilder.withPayload(msg)
                        .setHeader("contentType", "application/json")
                        .build()
        );

        return sended;
    }
}
