package com.example.poller.workers;

import com.example.web.domain.ChatMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import com.example.poller.infraestructure.binders.MessagesProcessor;
import org.springframework.scheduling.annotation.Async;
import reactor.core.publisher.Flux;

@EnableBinding(value = { MessagesProcessor.class })
public class ChatMessagesWorker {

//    @Async
    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
    public void receive(ChatMessage chatMessage) {
        try {

            System.out.println(
              "Thread name is: " + Thread.currentThread().getName()
            );

            System.out.println(this.getClass().getName() + " -> processing");
            System.out.println( chatMessage.toString());
        } catch (Exception ex){
            System.out.println("error:" + ex.getMessage());
        }
    }

//    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
//    @Output(MessagesProcessor.MESSAGES_CHANNEL_OUT)
//    public Flux<ChatMessage> receive2(Flux<ChatMessage> chatMessage) {
//
//        return chatMessage.map(this::p);
//    }
//
//    private ChatMessage p(ChatMessage chat) {
//        System.out.println(chat.toString());
//        return chat;
//    }
}
