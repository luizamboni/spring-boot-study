package com.example.demo.publishers;

import com.example.demo.infrastructure.binders.MessagesProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Collections;


@EnableBinding(MessagesProcessor.class)
public class ChatMessagePublisher {

//    @Autowired
//    @Qualifier("sourceChannel")
//    private MessageChannel localChannel;
//
//    public Boolean publish(Object msg) {
//
//
//        MessageHeaders header = new MessageHeaders(
//            Collections.singletonMap(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
//        );
//
//        Message message = MessageBuilder.createMessage(msg, header);
//
//        localChannel.send(message);
//        return true;
//    }
}
