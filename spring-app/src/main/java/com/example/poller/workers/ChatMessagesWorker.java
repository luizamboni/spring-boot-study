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
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.util.Random;

@EnableBinding(value = { MessagesProcessor.class })
@EnableAutoConfiguration
public class ChatMessagesWorker {

    Random rand = new Random();


    @Async
    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
    public void receive(ChatMessage chatMessage) throws Exception {

        System.out.println(
          "(withour Flux)Thread name is: " + Thread.currentThread().getName()
        );

        System.out.println(this.getClass().getName() + " -> processing");
        System.out.println( chatMessage.toString());
        randomError();
    }


//    @StreamListener(value = MessagesProcessor.MESSAGES_CHANNEL_IN)
////    @Output(MessagesProcessor.MESSAGES_CHANNEL_OUT)
//    public void receive3(Flux<ChatMessage> messages) {
//        System.out.println(
//          "Thread name is: " + Thread.currentThread().getName()
//        );
//
//        messages
//            .subscribeOn(Schedulers.parallel())
//            .map(chatMessage -> {
//
//                System.out.println(
//                    "Thread name is: " + Thread.currentThread().getName()
//                );
//
//                System.out.println(this.getClass().getName() + " -> processing");
//
//                System.out.println(chatMessage.toString());
//
////                randomError();
//
//            return chatMessage;
//        }).subscribe(
//            chatMessage -> {
//                System.out.println(this.getClass().getName() + " -> ssussucesso");
//            },
//
//            ex -> {
//                System.out.println(this.getClass().getName() + " -> errão");
//
//            },
//            () -> {
//                System.out.println(this.getClass().getName() + " -> completed");
//
//            }
//        );
//    }


    private void randomError() throws Exception {


        if(rand.nextInt(100) < 60) {
            throw new Exception("random Error !");
        }
    }
}
