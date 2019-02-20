package com.example.poller.workers;

import com.example.web.domain.ChatMessage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import com.example.poller.infraestructure.binders.MessagesProcessor;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@EnableBinding(value = { MessagesProcessor.class })
@EnableAutoConfiguration
public class ChatMessagesWorker {

//    @Async
//    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
//    public void receive(ChatMessage chatMessage) {
//        try {
//
//            System.out.println(
//              "Thread name is: " + Thread.currentThread().getName()
//            );
//
//            System.out.println(this.getClass().getName() + " -> processing");
//            System.out.println( chatMessage.toString());
//        } catch (Exception ex){
//            System.out.println("error:" + ex.getMessage());
//        }
//    }

//    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
//    public void receive2(Flux<Message<String>> messages) {
//
//
//        messages.map(chatMessage -> {
//
//            System.out.println(
//                    "Thread name is: " + Thread.currentThread().getName()
//            );
//
//            System.out.println(this.getClass().getName() + " -> processing");
//            System.out.println(chatMessage.toString());
//
//            return chatMessage;
//        });
//    }

//    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
//    public void receive3(Flux<String> messages) {
//
//        System.out.println(
//            "Thread name is: " + Thread.currentThread().getName()
//        );

//        messages.map(chatMessage -> {
//
//            System.out.println(
//                "Thread name is: " + Thread.currentThread().getName()
//            );
//
//            System.out.println(this.getClass().getName() + " -> processing");
//            System.out.println(chatMessage.toString());
//
//            return chatMessage;
//        });
//    }


    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
    public void receive56(Flux<Message<ChatMessage>> messages) {


        System.out.println(
          "-----------------------------------------------------"
        );
        System.out.println(
                "Thread name is: " + Thread.currentThread().getName()
        );

        System.out.println(
            "-----------------------------------------------------"
        );

        System.out.println(messages.toString());
        System.out.println(
                "-----------------------------------------------------"
        );

      messages.subscribe(chatMsg ->
        System.out.println(chatMsg.toString())
      );
    }
}
