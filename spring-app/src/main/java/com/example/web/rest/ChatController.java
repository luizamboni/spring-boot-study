package com.example.web.rest;

import com.example.commons.domain.ChatMessage;
import com.example.web.infrastructure.binders.MessagesSource;
import com.example.web.publishers.ChatMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableBinding(value = { MessagesSource.class })
public class ChatController {


    @Autowired
    ChatMessagePublisher messagePublisher;

    @PostMapping("/message")
    public ResponseEntity sendMessage(@RequestBody ChatMessage chatMessageReceived) {


        System.out.println(this.getClass().getName() + " -> receiving");

        System.out.println(
            chatMessageReceived.toString()
        );

        Boolean sended = messagePublisher.publish(chatMessageReceived);


        if(sended == true) {
            return ResponseEntity.status(202).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }
}
