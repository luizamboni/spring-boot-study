package com.example.demo.rest;

import com.example.demo.domain.PollerMessage;
import com.example.demo.infrastructure.binders.MessagesProcessor;
import com.example.demo.publishers.ChatMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChatController {

    @Autowired
    MessagesProcessor messagePublisher;

    @PostMapping("/message")
    public ResponseEntity sendMessage(@RequestBody PollerMessage messageReceived) {


        System.out.println(this.getClass().getName() + " -> receiving");

        System.out.println(
            messageReceived.toString()
        );

        Boolean sended = messagePublisher.pollerOut().send(
            MessageBuilder.withPayload(messageReceived).build()
        );

        if(sended == true) {

            return ResponseEntity.status(202).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }
}
